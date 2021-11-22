package com.urcar.appliationurcar.userAdministration.domain.persistence;


import com.urcar.appliationurcar.userAdministration.domain.model.entity.Lessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessorRepository extends JpaRepository<Lessor,Long> {
    Lessor findByEmailAndPassword(String email, String password);

}
