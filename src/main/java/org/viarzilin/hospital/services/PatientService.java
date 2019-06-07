package org.viarzilin.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.viarzilin.hospital.domain.Patient;
import org.viarzilin.hospital.repository.PatientRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public void save(Patient patient) {

        if (patient.getCreatedDate() == null){
            patient.setCreatedDate(LocalDateTime.now());
        }
        patient.setUpdatedDate(LocalDateTime.now());

        patientRepository.save(patient);

    }


    public boolean findUserByExample(Patient patient) {

        Example<Patient> patientExample = Example.of(patient);
        Optional<Patient> actual = patientRepository.findOne(patientExample);

        return actual.isPresent();
    }

}
