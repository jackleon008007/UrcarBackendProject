package com.urcar.appliationurcar.publications.mapping;

import com.urcar.appliationurcar.publications.domain.model.entity.Reservation;

import com.urcar.appliationurcar.publications.resource.CreateReservationResource;
import com.urcar.appliationurcar.publications.resource.ReservationResource;
import com.urcar.appliationurcar.publications.resource.UpdateReservationResource;
import com.urcar.appliationurcar.shared.mapping.EnhancedModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ReservationMapper implements Serializable {


    private EnhancedModelMapper mapper;
    public ReservationMapper(EnhancedModelMapper mapper){
        this.mapper = mapper;
    }

    public ReservationResource toResource(Reservation model){
        return mapper.map(model,ReservationResource.class);
    }

    public Page<ReservationResource> modelListToPage(List<Reservation> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,ReservationResource.class),pageable, modelList.size());
    }

    public Reservation toModel(CreateReservationResource resource){

        return mapper.map(resource,Reservation.class);
    }

    public Reservation toModel(UpdateReservationResource resource){
        return mapper.map(resource,Reservation.class);
    }

}
