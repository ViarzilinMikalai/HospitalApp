package org.viarzilin.hospital.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.viarzilin.hospital.domain.Patient;
import org.viarzilin.hospital.services.PatientService;

import java.util.Map;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/allpatients")
    public String allPatients(Model model){
//        Iterable<Patient> patientss = patientService.patientList();
        model.addAttribute ("patients", patientService.patientList());

        return "allPatients";
    }



    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("some", "hello, letsCode!");
        return "main";
    }

}
