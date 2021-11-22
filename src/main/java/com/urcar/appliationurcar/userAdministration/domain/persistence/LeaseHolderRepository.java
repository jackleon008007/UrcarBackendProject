package com.urcar.appliationurcar.userAdministration.domain.persistence;

import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.Lessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseHolderRepository extends JpaRepository<LeaseHolder,Long> {
    LeaseHolder findByDNI(String dni);
    LeaseHolder findByEmailAndPassword(String email, String password);
}
