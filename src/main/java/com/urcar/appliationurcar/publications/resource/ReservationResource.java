package com.urcar.appliationurcar.publications.resource;

import com.urcar.appliationurcar.publications.domain.model.entity.Post;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResource {

    private Long id;

    private String title;

    private Long price;

    private Long leaseHolderId;

    private Long lessorId;

}
