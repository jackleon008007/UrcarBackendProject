package com.urcar.appliationurcar.publications.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urcar.appliationurcar.shared.domain.model.AuditModel;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.Lessor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name="post")
public class Post extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=150)
    @Column(unique=true)
    private String Title;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="lessor_id",nullable=false)
    @JsonIgnore
    private Lessor lessorId;

    @NotNull
    @Size(max=350)
    private String Description;

    @NotNull
    private Long Price;

    @NotNull
    private Long OwnerId;
    /*image no founf*/;

    @NotNull
    @Size(max=800)
    private String Content;

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
