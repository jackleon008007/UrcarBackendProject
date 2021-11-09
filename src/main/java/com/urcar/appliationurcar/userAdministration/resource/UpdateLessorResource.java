package com.urcar.appliationurcar.userAdministration.resource;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLessorResource {
    private Long id;
    @NotNull
    @Size(max=60)
    private String name;

    @NotNull
    @Size(max=100)
    private String lastName;

    @NotNull
    private Long dni;

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
    private Long driverlicense;
    @NotNull
    @Size(max=200)
    private String payMethods;
}
