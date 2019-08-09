package org.viarzilin.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.viarzilin.hospital.domain.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>, QueryByExampleExecutor<Department> {


}
