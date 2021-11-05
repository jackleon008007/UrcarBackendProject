package com.urcar.appliationurcar.userAdministration.domain.model.entity;


import com.urcar.appliationurcar.shared.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="leaseholder")
public class LeaseHolder extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
