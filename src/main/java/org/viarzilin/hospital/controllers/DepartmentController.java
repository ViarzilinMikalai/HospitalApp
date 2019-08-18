package org.viarzilin.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.viarzilin.hospital.domain.Department;
import org.viarzilin.hospital.services.DepartmentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public String departments(
            Model model,
            @RequestParam(required = false, defaultValue = "") Department removeDepartment,
            @RequestParam(required = false, defaultValue = "") Department repareDepartment,
            @RequestParam(required = false, value = "department") Department department
    ){
        if (removeDepartment != null){
            departmentService.remove(removeDepartment);
        }

        if (repareDepartment != null){
            departmentService.repare(repareDepartment);
        }

        if (department != null){
            model.addAttribute("department", new Department());
        }

        List<Department> departmentsList = departmentService.findAll();
        model.addAttribute("departmentsList", departmentsList);

        return "departments";
    }


    @PostMapping
    public String addOrUpdate(
            @Valid Department department,
            BindingResult bindingResult,
            Model model
    ){
        List<Department> departmentsList = departmentService.findAll();
        model.addAttribute("departmentsList", departmentsList);
        model.addAttribute("department", department);

        if(bindingResult.hasErrors()){

            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);

            return "departments";

        } else {

            if (!departmentService.saveDepartment(department)){

                model.addAttribute("savingReport", "Department is Exists");
                return "departments";

            } else {

                return "redirect:departments";
            }
        }

    }

}