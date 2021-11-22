package com.urcar.appliationurcar.publications.service;

import com.urcar.appliationurcar.publications.domain.model.entity.Post;
import com.urcar.appliationurcar.publications.domain.persistence.PostRepository;
import com.urcar.appliationurcar.publications.domain.service.PostService;
import com.urcar.appliationurcar.shared.exception.ResourceNotFoundException;
import com.urcar.appliationurcar.shared.exception.ResourceValidationException;
import com.urcar.appliationurcar.userAdministration.domain.persistence.LessorRepository;
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
public class PostServiceImpl implements PostService {

    private static final String ENTITY ="Post";
    private final PostRepository postRepository;
    private final LessorRepository lessorRepository;
    private final Validator validator;
    public PostServiceImpl(PostRepository postRepository, LessorRepository lessorRepository, Validator validator){
        this.postRepository=postRepository;
        this.lessorRepository = lessorRepository;
        this.validator = validator;
    }
    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Page<Post> getAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post getById(Long postId) {
        return postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException(ENTITY,postId));
    }

    @Override
    @Transactional
    public Post create(Long lessoId, Post post) {
        Set<ConstraintViolation<Post>> violations = validator.validate(post);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Post postWithTitle = postRepository.findByTitle(post.getTitle());

        if(postWithTitle != null)
            throw new ResourceValidationException(ENTITY,"A post with the same title already exists.");


        return lessorRepository.findById(lessoId).map(lessor->{
            post.setLessor(lessor);
            return postRepository.save(post);
        }).orElseThrow(()-> new ResourceNotFoundException("Lessor",lessoId));
    }

    @Override
    @Transactional
    public Post update(Long postId, Post request) {

        Set<ConstraintViolation<Post>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }
            return postRepository.findById(postId).map(
                    post-> postRepository.save(post.withTitle(request.getTitle())
                            .withDescription(request.getDescription())
                            .withContent(request.getContent())
                            .withBootType(request.getBootType())
                            .withFabricationYear(request.getFabricationYear())
                            .withImageurl(request.getImageurl())
                            .withLikes(request.getLikes())
                            .withModelCar(request.getModelCar())
                            .withNumberDoors(request.getNumberDoors())
                            .withNumberSeats(request.getNumberSeats())
                            .withPlate(request.getPlate())
                            .withPrice(request.getPrice())))
                    .orElseThrow(()-> new ResourceNotFoundException(ENTITY,postId));
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(Long postId) {
        return postRepository.findById(postId).map(post->{
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,postId));
    }
}
