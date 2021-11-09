package com.urcar.appliationurcar.userAdministration.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class LessorResource {
    private Long id;

    private String name;

    private String lastName;

    private Long dni;

    private Long age;

    private String address;

    private String type;

    private String imageProfile;

    private Long numberPhone;

    private String email;

    private String licensePlate;

    private String district;

    private Long postalCode;

    private String experience;

    private String recomends;

    private String password;

    private Long driverlicense;

    private String payMethods;
}
