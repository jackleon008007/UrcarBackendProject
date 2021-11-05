package com.urcar.appliationurcar.publications.domain.model.entity;

import com.urcar.appliationurcar.shared.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name="reservation")
public class Reservation extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=150)
    @Column(unique=true)
    private String Title;

    @NotNull
    private Long Price;

    @NotNull
    private Long carId;

}
