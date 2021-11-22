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
public class CreateReservationResource {

    @NotNull
    @Size(max=150)
    private String title;

    @NotNull
    private Long price;
    @NotNull
    private Long leaseHolderId;
    @NotNull
    private Long lessorId;

}
