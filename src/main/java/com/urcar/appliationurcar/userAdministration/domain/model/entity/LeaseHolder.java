package com.urcar.appliationurcar.userAdministration.domain.model.entity;


import com.urcar.appliationurcar.shared.domain.model.AuditModel;
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
@Table(name="leaseholder")
public class LeaseHolder extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=60)
    private String name;

    @NotNull
    @Size(max=100)
    private String lastName;

    @NotNull
    private Long DNI;

    @NotNull
    private Long age;

    @NotNull
    @Size(max=200)
    private String address;

    @NotNull
    @Size(max=80)
    private String type;

    @NotNull
    @Size(max=120)
    private String imageProfile;

    @NotNull
    private Long numberPhone;
    @NotNull
    @Size(max=150)
    private String email;
    @NotNull
    @Size(max=60)
    private String licensePlate;
    @NotNull
    @Size(max=100)
    private String district;
    @NotNull
    private Long postalCode;
    @NotNull
    @Size(max=900)
    private String experience;
    @NotNull
    @Size(max=200)
    private String recomends;

    @NotNull
    @Size(max=200)
    private String password;
    @NotNull
    private Long Driverlicense;
    @NotNull
    @Size(max=200)
    private String PayMethods;
}
