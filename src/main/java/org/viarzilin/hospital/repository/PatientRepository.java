package org.viarzilin.hospital.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.viarzilin.hospital.domain.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long>, QueryByExampleExecutor<Patient> {

    Page<Patient> findAll(Pageable pageable);


    Page<Patient> findByLastnameStartingWithIgnoreCaseAndFirstnameStartingWithIgnoreCase(
            @Param("lastname") String lastname,
            @Param("firstname") String firstname,
            Pageable pageable
    );

}
