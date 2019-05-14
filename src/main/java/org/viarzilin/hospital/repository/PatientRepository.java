package org.viarzilin.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.viarzilin.hospital.domain.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
