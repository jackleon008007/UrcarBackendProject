package com.urcar.appliationurcar.publications.domain.persistence;

import com.urcar.appliationurcar.publications.domain.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {


}
