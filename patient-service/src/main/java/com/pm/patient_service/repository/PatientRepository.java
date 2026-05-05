package com.pm.patient_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pm.patient_service.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    // <pass in the entity we want to control and the type of its id>
    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, UUID id);
}
