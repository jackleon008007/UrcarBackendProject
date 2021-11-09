package com.urcar.appliationurcar.userAdministration.domain.persistence;

import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseHolderRepository extends JpaRepository<LeaseHolder,Long> {
    LeaseHolder findByDNI(String dni);
}
