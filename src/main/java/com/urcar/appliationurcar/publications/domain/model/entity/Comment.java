package com.urcar.appliationurcar.publications.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urcar.appliationurcar.shared.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
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
    private Post postId;
}
