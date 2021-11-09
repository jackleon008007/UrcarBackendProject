package com.urcar.appliationurcar.publications.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urcar.appliationurcar.publications.domain.model.entity.Post;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentResource {

    @NotNull
    @Size(max=700)
    private String text;


}
