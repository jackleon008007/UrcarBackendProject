package com.urcar.appliationurcar.userAdministration.domain.service;


import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LeaseHolderService {
    List<LeaseHolder> getAll();
    Page<LeaseHolder> getAll(Pageable pageable);
    LeaseHolder getById(Long leaseHolderId);
    LeaseHolder create(LeaseHolder leaseHolder);
    LeaseHolder update(Long leaseHolderId, LeaseHolder request);
    ResponseEntity<?> delete(Long leaseHolderId);

}
