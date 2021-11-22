package com.urcar.appliationurcar.publications.api;



import com.urcar.appliationurcar.publications.domain.service.ReservationService;

import com.urcar.appliationurcar.publications.mapping.ReservationMapper;
import com.urcar.appliationurcar.publications.resource.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name="Post")
@RestController
@RequestMapping("/api/v1/post/{postId}/reservation")
public class BookingsController {
    private final ReservationService reservationService;
    private final ReservationMapper mapper;


    public BookingsController(ReservationService reservationService, ReservationMapper mapper) {
        this.reservationService = reservationService;
        this.mapper = mapper;
    }


    @GetMapping
    public Page<ReservationResource> getAllReservationByPostId(@PathVariable Long postId, Pageable pageable){
        return mapper.modelListToPage(reservationService.getAllByPostId(postId),pageable);
    }

    @PostMapping(consumes="application/json")
    public ReservationResource createReservation(@PathVariable Long postId,
                                             @RequestBody CreateReservationResource request){
        return mapper.toResource(reservationService.create(postId,mapper.toModel(request)));
    }

    @PutMapping("{reservationId}")
    public ReservationResource updateReservation(@PathVariable Long postId,
                                         @PathVariable Long reservationId,
                                         @RequestBody UpdateReservationResource request){
        return mapper.toResource(reservationService.update(postId,reservationId,mapper.toModel(request)));
    }

    @DeleteMapping("{reservationId}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long postId,
                                           @PathVariable Long reservationId){
        return reservationService.delete(postId,reservationId);
    }


}
