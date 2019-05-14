package org.viarzilin.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.viarzilin.hospital.domain.Patient;
import org.viarzilin.hospital.repository.PatientRepository;

import java.util.List;


@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;


    public Iterable<Patient> patientList() {
        return patientRepository.findAll();
    }
}
