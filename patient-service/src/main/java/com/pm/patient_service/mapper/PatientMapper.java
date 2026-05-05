package com.pm.patient_service.mapper;

import java.time.LocalDate;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.model.Patient;

public class PatientMapper {

    // this is the helper class that will accept the domain entity model and return
    // the dto

    public static PatientResponseDto toDTO(Patient patient) {
        // here the return type is PatientResponseDto and tpDTO will accept PAtient
        // which is domain entity object and later we will instantiate a new
        // PatientResponse DTO

        PatientResponseDto patientDto = new PatientResponseDto();
        patientDto.setId(patient.getId().toString());
        patientDto.setName(patient.getName().toString());
        patientDto.setAddress(patient.getAddress().toString());
        patientDto.setEmail(patient.getEmail().toString());
        patientDto.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDto;
    }

    public static Patient toModel(PatientRequestDto patientRequestDto) {
        Patient patient = new Patient();
        patient.setName(patientRequestDto.getName());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDto.getRegestiredDate()));

        return patient;

    }

}
