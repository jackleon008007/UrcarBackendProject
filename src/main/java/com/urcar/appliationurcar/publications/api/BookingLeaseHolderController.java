package com.urcar.appliationurcar.publications.api;

import com.urcar.appliationurcar.publications.domain.service.ReservationService;
import com.urcar.appliationurcar.publications.mapping.ReservationMapper;
import com.urcar.appliationurcar.publications.resource.ReservationResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name="Post")
@RestController
@RequestMapping("/api/v1/leaseHolder/{leaseHolderId}/reservation")
public class BookingLeaseHolderController {


    private final ReservationService reservationService;
    private final ReservationMapper mapper;

    public BookingLeaseHolderController(ReservationService reservationService, ReservationMapper mapper) {
        this.reservationService = reservationService;
        this.mapper = mapper;
    }
    @GetMapping
    public Page<ReservationResource> getAllReservationByLeaseHolderId(@PathVariable Long leaseHolderId, Pageable pageable){
        return mapper.modelListToPage(reservationService.getAllByLeasHolderId(leaseHolderId),pageable);
    }
}
