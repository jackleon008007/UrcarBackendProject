package com.urcar.appliationurcar.publications.service;

import com.urcar.appliationurcar.publications.domain.model.entity.Reservation;
import com.urcar.appliationurcar.publications.domain.persistence.PostRepository;
import com.urcar.appliationurcar.publications.domain.persistence.ReservationRepository;
import com.urcar.appliationurcar.publications.domain.service.ReservationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    public ReservationServiceImpl(ReservationRepository reservationRepository){
        this.reservationRepository=reservationRepository;
    }
    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Page<Reservation> getAll(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }
}
