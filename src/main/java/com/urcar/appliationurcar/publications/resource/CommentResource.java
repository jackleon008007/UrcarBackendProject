package com.urcar.appliationurcar.publications.resource;

import com.urcar.appliationurcar.publications.domain.model.entity.Post;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CommentResource {

    private Long id;

    private String text;


}
