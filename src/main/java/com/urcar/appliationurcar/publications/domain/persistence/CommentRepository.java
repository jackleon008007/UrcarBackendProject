package com.urcar.appliationurcar.publications.domain.persistence;

import com.urcar.appliationurcar.publications.domain.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPostId(Long postId);
    Page<Comment> findByPostId(Long postId, Pageable pageable);
    Optional<Comment> findByIdAndPostId(Long id, Long postId);

}
