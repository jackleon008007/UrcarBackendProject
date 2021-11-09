package com.urcar.appliationurcar.publications.domain.model.entity;

import com.urcar.appliationurcar.shared.domain.model.AuditModel;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
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
    private String Title;

    @NotNull
    private Long Price;


    @ManyToOne
    @JoinColumn(name = "post_id")
    @NotNull
    private Post post;

    @ManyToOne
    @JoinColumn(name = "lease_holder_id")
    private LeaseHolder leaseHolder;

}
