package org.viarzilin.hospital.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.viarzilin.hospital.domain.Department;
import org.viarzilin.hospital.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    Department department;
    Department departmentTwo;

    @Before
    public void setUp(){
       department = new Department();
       department.setName("therapy2");
       department.setDeleted(false);

       departmentTwo = new Department();
       departmentTwo.setName("therapy");
       departmentTwo.setDeleted(true);

    }


    @Test
    public void saveDepartment() {
        /*
        If Department is exists, isDepartmentCreated return false, else return true
         */
        when(departmentRepository.findByNameIgnoreCase("therapy2")).thenReturn(department);
        boolean isDepartmentCreated = departmentService.saveDepartment(departmentTwo);
        Assert.assertTrue(isDepartmentCreated);

        when(departmentRepository.findByNameIgnoreCase("therapy2")).thenReturn(department);
        isDepartmentCreated = departmentService.saveDepartment(department);
        Assert.assertFalse(isDepartmentCreated);
    }


    @Test
    public void findAll() {
        List<Department> deptsList = new ArrayList<>();
        deptsList.add(0, department);
        deptsList.add(1, departmentTwo);

        when(departmentRepository.findAll()).thenReturn(deptsList);
        List<Department> listFromBd = departmentService.findAll();

        Department departmentThree = new Department();

        /*
            If departmentRepository.findAll() return notEmpty listFromdb
         */
        System.out.println(listFromBd);
        Assert.assertTrue(listFromBd.contains(department));
        Assert.assertTrue(listFromBd.contains(departmentTwo));
        Assert.assertFalse(listFromBd.contains(departmentThree));

        /*
            If departmentRepository.findAll() return empty listFromdb
        */
        deptsList = new ArrayList<>();
        when(departmentRepository.findAll()).thenReturn(deptsList);
        List<Department> listFromBdTwo = departmentService.findAll();
        Assert.assertTrue(listFromBdTwo.isEmpty());
    }


    @Test
    public void remove() {
       departmentService.remove(department);
       Assert.assertTrue(department.isDeleted());
    }


    @Test
    public void repare() {
       departmentService.repare(departmentTwo);
       Assert.assertFalse(departmentTwo.isDeleted());
    }
}