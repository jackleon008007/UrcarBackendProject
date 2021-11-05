package com.urcar.appliationurcar.publications.domain.persistence;

import com.urcar.appliationurcar.publications.domain.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
