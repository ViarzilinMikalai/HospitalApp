package org.viarzilin.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.viarzilin.hospital.domain.Department;
import org.viarzilin.hospital.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;


    public boolean saveDepartment(Department department){


        if (departmentRepository.findByNameIgnoreCase(department.getName()) == null){

            departmentRepository.save(department);
            return true;

        } else {

            return false;
        }

    }


    public List<Department> findAll() {

        List<Department> listDepartments = new ArrayList<>();
        departmentRepository.findAll().forEach(listDepartments::add);

        List<Department> sortedListDepartments = listDepartments.stream()
            .sorted(Comparator.comparing(Department::getName))
            .collect(Collectors.toList());

        return sortedListDepartments;
    }


    public void remove(Department department) {
        department.setDeleted(true);
        departmentRepository.save(department);
    }


    public void repare(Department department) {
        department.setDeleted(false);
        departmentRepository.save(department);
    }
}
