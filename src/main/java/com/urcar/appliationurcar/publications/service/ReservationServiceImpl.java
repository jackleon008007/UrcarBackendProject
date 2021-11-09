package com.urcar.appliationurcar.publications.service;

import com.urcar.appliationurcar.publications.domain.model.entity.Comment;
import com.urcar.appliationurcar.publications.domain.model.entity.Reservation;
import com.urcar.appliationurcar.publications.domain.persistence.PostRepository;
import com.urcar.appliationurcar.publications.domain.persistence.ReservationRepository;
import com.urcar.appliationurcar.publications.domain.service.ReservationService;
import com.urcar.appliationurcar.shared.exception.ResourceNotFoundException;
import com.urcar.appliationurcar.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class ReservationServiceImpl implements ReservationService {


    private static final String ENTITY ="reservation";
    private final PostRepository postRepository;
    private final Validator validator;
    private final ReservationRepository reservationRepository;
    public ReservationServiceImpl(PostRepository postRepository,
                                  Validator validator, ReservationRepository reservationRepository){
        this.postRepository = postRepository;
        this.validator = validator;
        this.reservationRepository=reservationRepository;

    }

    @Override
    public List<Reservation> getAllByPostId(Long postId) {
        return reservationRepository.findByPostId(postId);
    }

    @Override
    public Page<Reservation> getAllByPostId(Long postId, Pageable pageable) {
        return reservationRepository.findByPostId(postId,pageable);
    }

    @Override
    @Transactional
    public Reservation update(Long postId, Long reservationId, Reservation request) {
        Set<ConstraintViolation<Reservation>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }
        if(!postRepository.existsById(postId)){
            throw new ResourceNotFoundException("Post",postId);
        }
        return reservationRepository.findById(reservationId).map(
                        reservation-> reservationRepository.save(reservation.withLeaseHolder(request.getLeaseHolder())
                                .withPrice(request.getPrice()).withTitle(request.getTitle())))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,reservationId));
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(Long postId, Long reservationId) {
        return reservationRepository.findByIdAndPostId(reservationId,postId).map(reservation->{
            reservationRepository.delete(reservation);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,reservationId));
    }

    @Override
    @Transactional
    public Reservation create(Long postId, Reservation request) {
        Set<ConstraintViolation<Reservation>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }
        return postRepository.findById(postId).map(post->{
            request.setPost(post);
            return reservationRepository.save(request);
        }).orElseThrow(()-> new ResourceNotFoundException("Post",postId));
    }
}
