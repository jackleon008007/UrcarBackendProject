package com.urcar.appliationurcar.publications.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urcar.appliationurcar.shared.domain.model.AuditModel;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.Lessor;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name="reservation")
public class Reservation extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=150)
    private String title;

    @NotNull
    private Long price;


    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="post_id",nullable = false)
    @JsonIgnore
    private Post post;

    @NotNull
    private Long leaseHolderId;
    @NotNull
    private Long lessorId;

}
