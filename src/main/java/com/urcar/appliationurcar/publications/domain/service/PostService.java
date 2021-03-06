package com.urcar.appliationurcar.publications.domain.service;

import com.urcar.appliationurcar.publications.domain.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    List<Post> getAll();
    Page<Post> getAll(Pageable pageable);
    Post getById(Long postId);
    Post create(Long lessorId,Post post);
    Post update(Long postId, Post request);
    ResponseEntity<?> delete(Long postId);

}
