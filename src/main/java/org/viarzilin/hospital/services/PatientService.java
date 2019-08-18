package org.viarzilin.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.viarzilin.hospital.domain.Patient;
import org.viarzilin.hospital.repository.PatientRepository;

import java.util.Optional;


@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    public Page<Patient> patientList(String lastnameFilter, String firstnameFilter, Pageable pageable) {

        if (lastnameFilter == null && firstnameFilter == null){

            return patientRepository.findAll(pageable);

        } else {

            return patientRepository.findByLastnameStartingWithIgnoreCaseAndFirstnameStartingWithIgnoreCase(
                lastnameFilter, firstnameFilter, pageable
            );
        }

    }

    public boolean save(Patient patient) {
/*
        if (patient.getCreatedDate() == null){
            patient.setCreatedDate(LocalDateTime.now());
        }
        patient.setUpdatedDate(LocalDateTime.now());*/

        Example<Patient> patientExample = Example.of(patient);
        Optional<Patient> actual = patientRepository.findOne(patientExample);

        if (actual.isPresent()){

            return false;

        } else {

            patientRepository.save(patient);
            return true;
        }
    }


    public void remove(Patient patient) {
        patient.setDeleted(true);
        patientRepository.save(patient);
    }


    public void repare(Patient patient) {
        patient.setDeleted(false);
        patientRepository.save(patient);
    }
}
