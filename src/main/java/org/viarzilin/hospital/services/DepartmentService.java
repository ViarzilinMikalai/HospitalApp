package org.viarzilin.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.viarzilin.hospital.domain.Department;
import org.viarzilin.hospital.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public void saveDepartment(Department department){
        departmentRepository.save(department);
    }


    public List<Department> findAll() {
        List<Department> listDepartments = new ArrayList<>();
        departmentRepository.findAll().forEach(listDepartments::add);

        return listDepartments;
    }

//    public void delete(Department department) {
//        department.setDeleted(true);
//        departmentRepository.save(department);
//    }

    public void remove(Department department) {
        department.setDeleted(true);
        departmentRepository.save(department);
    }

    public void repare(Department department) {
        department.setDeleted(false);
        departmentRepository.save(department);
    }

    public boolean findByExample(Department department) {

        Example<Department> departmentExample = Example.of(department);
        Optional<Department> actual = departmentRepository.findOne(departmentExample);

        return actual.isPresent();
    }

}
