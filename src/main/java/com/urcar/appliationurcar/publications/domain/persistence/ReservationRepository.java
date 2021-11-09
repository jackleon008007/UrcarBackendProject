package com.urcar.appliationurcar.publications.domain.persistence;

import com.urcar.appliationurcar.publications.domain.model.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByPostId(Long postId);
    Page<Reservation> findByPostId(Long postId, Pageable pageable);
    Optional<Reservation> findByIdAndPostId(Long id, Long postId);

}
