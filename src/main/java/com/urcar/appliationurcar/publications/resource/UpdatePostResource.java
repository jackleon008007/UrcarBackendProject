package com.urcar.appliationurcar.publications.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.Lessor;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostResource {


    private Long id;

    @NotNull
    @Size(max=150)
    private String title;



    @NotNull
    @Size(max=350)
    private String description;

    @NotNull
    private Long price;

    @NotNull
    private Long ownerId;
    /*image no founf*/;

    @NotNull
    @Size(max=800)
    private String content;

    @NotNull
    private Date fabricationYear;

    @NotNull
    private Long likes;

    @NotNull
    @Size(max=200)
    private String modelCar;

    @NotNull
    private Long numberSeats;

    @NotNull
    private Long numberDoors;

    @NotNull
    @Size(max=100)
    private String bootType;

    @NotNull
    @Size(max=50)
    private String plate;


}