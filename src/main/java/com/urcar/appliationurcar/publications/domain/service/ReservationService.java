package com.urcar.appliationurcar.publications.domain.service;

import com.urcar.appliationurcar.publications.domain.model.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAll();
    Page<Reservation> getAll(Pageable pageable);
}
