package com.urcar.appliationurcar.publications.domain.service;

import com.urcar.appliationurcar.publications.domain.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    List<Post> getAll();
    Page<Post> getAll(Pageable pageable);
}
