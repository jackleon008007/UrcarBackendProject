package com.urcar.appliationurcar.publications.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urcar.appliationurcar.shared.domain.model.AuditModel;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
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
@Table(name="comment")
public class Comment extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=700)
    private String text;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="post_id",nullable=false)
    @JsonIgnore
    private Post post;


    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="leaseHolder_id",nullable=false)
    @JsonIgnore
    private LeaseHolder leaseHolderId;
}
