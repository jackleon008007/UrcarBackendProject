package com.urcar.appliationurcar.userAdministration.service;

import com.urcar.appliationurcar.shared.exception.ResourceNotFoundException;
import com.urcar.appliationurcar.shared.exception.ResourceValidationException;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.Lessor;
import com.urcar.appliationurcar.userAdministration.domain.persistence.LessorRepository;
import com.urcar.appliationurcar.userAdministration.domain.service.LessorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;


@Service
@Transactional(readOnly = true)
public class LessorServiceImpl implements LessorService {

    private static final String ENTITY ="Post";
    private final LessorRepository lessorRepository;
    private final Validator validator;
    public LessorServiceImpl(LessorRepository lessorRepository, Validator validator){
        this.lessorRepository = lessorRepository;
        this.validator = validator;
    }

    @Override
    public List<Lessor> getAll() {
        return lessorRepository.findAll();
    }

    @Override
    public Page<Lessor> getAll(Pageable pageable) {
        return lessorRepository.findAll(pageable);
    }

    @Override
    public Lessor getById(Long lessorId) {
        return lessorRepository.findById(lessorId).orElseThrow(()-> new ResourceNotFoundException(ENTITY,lessorId));
    }

    @Override
    @Transactional
    public Lessor create(Lessor lessor) {
        Set<ConstraintViolation<Lessor>> violations = validator.validate(lessor);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }
        return lessorRepository.save(lessor);
    }

    @Override
    @Transactional
    public Lessor update(Long lessorId, Lessor request) {
        Set<ConstraintViolation<Lessor>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }
        return lessorRepository.findById(lessorId).map(
                        lessor-> lessorRepository.save(lessor.withName(request.getName())
                                .withDni(request.getDni())
                                .withAge(request.getAge())
                                .withLastName(request.getLastName())
                                .withAddress(request.getAddress())
                                .withDistrict(request.getDistrict())
                                .withEmail(request.getEmail())
                                .withDriverlicense(request.getDriverlicense())
                                .withExperience(request.getExperience())
                                .withNumberPhone(request.getNumberPhone())
                                .withPassword(request.getPassword())
                                .withLicensePlate(request.getLicensePlate())
                                .withPostalCode(request.getPostalCode())
                                .withType(request.getType())
                                .withPayMethods(request.getPayMethods())))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,lessorId));
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(Long lessorId) {
        return lessorRepository.findById(lessorId).map(lessor->{
            lessorRepository.delete(lessor);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,lessorId));
    }

    @Override
    public Lessor finByEmailAndPassword(String email, String password) {
        return lessorRepository.findByEmailAndPassword(email,password);
    }
}
