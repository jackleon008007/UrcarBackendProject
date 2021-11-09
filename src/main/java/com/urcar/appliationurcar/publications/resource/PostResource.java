package com.urcar.appliationurcar.publications.resource;



import com.urcar.appliationurcar.userAdministration.domain.model.entity.Lessor;
import lombok.*;


import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PostResource {

    private Long id;
    private String title;
    private String description;
    private Long price;
    private Long ownerId;
    private String content;
    private Date fabricationYear;
    private Long likes;
    private String modelCar;
    private Long numberSeats;
    private Long numberDoors;
    private String bootType;
    private String plate;

}
