package com.urcar.appliationurcar.userAdministration.service;

import com.urcar.appliationurcar.publications.domain.model.entity.Post;
import com.urcar.appliationurcar.shared.exception.ResourceNotFoundException;
import com.urcar.appliationurcar.shared.exception.ResourceValidationException;
import com.urcar.appliationurcar.userAdministration.domain.model.entity.LeaseHolder;
import com.urcar.appliationurcar.userAdministration.domain.persistence.LeaseHolderRepository;
import com.urcar.appliationurcar.userAdministration.domain.service.LeaseHolderService;
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
public class LeaseHolderServiceImpl implements LeaseHolderService {



    private static final String ENTITY ="Post";
    private final LeaseHolderRepository leaseHolderRepository;
    private final Validator validator;
    public LeaseHolderServiceImpl(LeaseHolderRepository leaseHolderRepository, Validator validator){

        this.leaseHolderRepository = leaseHolderRepository;
        this.validator = validator;
    }


    @Override
    public List<LeaseHolder> getAll() {
        return leaseHolderRepository.findAll();
    }

    @Override
    public Page<LeaseHolder> getAll(Pageable pageable) {
        return leaseHolderRepository.findAll(pageable);
    }

    @Override
    public LeaseHolder getById(Long leaseHolderId) {
        return leaseHolderRepository.findById(leaseHolderId).orElseThrow(()-> new ResourceNotFoundException(ENTITY,leaseHolderId));
    }

    @Override
    @Transactional
    public LeaseHolder create(LeaseHolder leaseHolder) {
        Set<ConstraintViolation<LeaseHolder>> violations = validator.validate(leaseHolder);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }
        return leaseHolderRepository.save(leaseHolder);
    }

    @Override
    @Transactional
    public LeaseHolder update(Long leaseHolderId, LeaseHolder request) {
        Set<ConstraintViolation<LeaseHolder>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }
        return leaseHolderRepository.findById(leaseHolderId).map(
                        leaseHolder-> leaseHolderRepository.save(leaseHolder.withName(request.getName())
                                .withDNI(request.getDNI())
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
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,leaseHolderId));
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(Long leaseHolderId) {
        return leaseHolderRepository.findById(leaseHolderId).map(leaseHolder->{
            leaseHolderRepository.delete(leaseHolder);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,leaseHolderId));
    }

    @Override
    public LeaseHolder finByEmailAndPassword(String email, String password) {
        return leaseHolderRepository.findByEmailAndPassword(email,password);
    }
}
