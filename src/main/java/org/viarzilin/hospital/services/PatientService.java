package org.viarzilin.hospital.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.viarzilin.hospital.domain.Patient;
import org.viarzilin.hospital.domain.User;
import org.viarzilin.hospital.repository.PatientRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PatientService {
    public final PatientRepository patientRepository;


    public Page<Patient> patientList(String lastnameFilter, String firstnameFilter, Pageable pageable) {
        if (lastnameFilter == null && firstnameFilter == null){
            return patientRepository.findAll(pageable);
        } else {
            return patientRepository.findByLastnameStartingWithIgnoreCaseAndFirstnameStartingWithIgnoreCase(
                lastnameFilter, firstnameFilter, pageable
            );
        }
    }

    public void save(Patient patient) {
        patientRepository.save(patient);
    }


    public void edit(Patient patient, Patient oldPatient) {
        patient.setId(oldPatient.getId());
        patientRepository.save(patient);
    }


    public void remove(Patient patient) {
        patient.setDeleted(!patient.isDeleted());
        patientRepository.save(patient);
    }
}
