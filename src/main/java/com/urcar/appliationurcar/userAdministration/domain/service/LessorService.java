package com.urcar.appliationurcar.userAdministration.domain.service;


import com.urcar.appliationurcar.userAdministration.domain.model.entity.Lessor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LessorService {
    List<Lessor> getAll();
    Page<Lessor> getAll(Pageable pageable);
    Lessor getById(Long lessorId);
    Lessor create(Lessor lessor);
    Lessor update(Long lessorId, Lessor request);
    ResponseEntity<?> delete(Long lessorId);
    Lessor finByEmailAndPassword(String email, String password);
}
