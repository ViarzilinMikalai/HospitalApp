package org.viarzilin.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.viarzilin.hospital.domain.Patient;
import org.viarzilin.hospital.repository.PatientRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


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

    public void save(Patient patient, String birthDate) {

        patient.setBirthDate(LocalDate.parse(birthDate));
        if (patient.getCreatedDate() == null){
            patient.setCreatedDate(LocalDateTime.now());
        }
        patient.setUpdatedDate(LocalDateTime.now());

        patientRepository.save(patient);
    }

}
