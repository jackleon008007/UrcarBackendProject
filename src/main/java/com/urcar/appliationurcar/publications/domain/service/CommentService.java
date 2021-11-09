package com.urcar.appliationurcar.publications.domain.service;

import com.urcar.appliationurcar.publications.domain.model.entity.Comment;

import com.urcar.appliationurcar.publications.domain.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    List<Comment> getAllByPostId(Long postId);

    Page<Comment> getAllByPostId(Long postId,Pageable pageable);
    Comment update(Long postId, Long commentId, Comment request);
    ResponseEntity<?> delete(Long postId,Long commentId);

    Comment create(Long postId, Comment request);

}
