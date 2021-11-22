package com.urcar.appliationurcar.publications.domain.service;

import com.urcar.appliationurcar.publications.domain.model.entity.Comment;
import com.urcar.appliationurcar.publications.domain.model.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllByPostId(Long postId);
    Page<Reservation> getAllByPostId(Long postId,Pageable pageable);
    Reservation update(Long postId, Long reservationId, Reservation request);
    ResponseEntity<?> delete(Long postId, Long reservationId);
    Reservation create(Long postId,Reservation reservation);
    List<Reservation> getAllByLessorId(Long lessorId);
    List<Reservation> getAllByLeasHolderId(Long leaseHolderId);
    Reservation getByLessorIdAndLeaseHolderId(Long lessorId, Long leaseHolderId);

}
