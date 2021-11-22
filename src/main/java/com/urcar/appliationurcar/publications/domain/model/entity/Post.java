package com.urcar.appliationurcar.publications.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urcar.appliationurcar.shared.domain.model.AuditModel;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.Lessor;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name="post")
public class Post extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max=150)
    @Column(unique=true)
    private String title;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="lessor_id",nullable = false)
    @JsonIgnore
    private Lessor lessor;

    @NotNull
    @NotBlank
    @Size(max=350)
    private String description;

    @NotNull
    private Long price;

    @NotNull
    private Long ownerId;
    /*image no founf*/;

    @NotNull
    @NotBlank
    @Size(max=800)
    private String content;

    @NotNull
    private Date fabricationYear;

    @NotNull
    private Long likes;

    @NotNull
    @NotBlank
    @Size(max=200)
    private String modelCar;

    @NotNull
    private Long numberSeats;

    @NotNull
    private Long numberDoors;

    @NotNull
    @NotBlank
    @Size(max=100)
    private String bootType;

    @NotNull
    @NotBlank
    @Size(max=50)
    private String plate;

    @NotNull
    @NotBlank
    @Size(max=200)
    private String imageurl;


}
