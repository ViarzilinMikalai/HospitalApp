package org.viarzilin.hospital.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.viarzilin.hospital.domain.Patient;
import org.viarzilin.hospital.services.PatientService;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/allpatients")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping
    public String allPatients(
            @RequestParam(required = false, defaultValue = "") String lastnameFilter,
            @RequestParam(required = false, defaultValue = "") String firstnameFilter,
            Model model,
            @RequestParam(value = "patient", required = false) Patient patient
        ){
        model.addAttribute ("patients", patientService.patientList(lastnameFilter, firstnameFilter));
        model.addAttribute("lastnameFilter", lastnameFilter);
        model.addAttribute("firstnameFilter", firstnameFilter);
        if (patient != null) {
            model.addAttribute("patient", patient);
            model.addAttribute("birthDates", patient.getBirthDate());
        }
        return "allpatients";
    }


//    @GetMapping("search")
//    public String filterPatients(
//        @RequestParam(required = false, defaultValue = "") String lastnameFilter,
//        @RequestParam(required = false, defaultValue = "") String firstnameFilter,
//        Model model
//    ){
//        model.addAttribute("patients", patientService.findByFilters(lastnameFilter, firstnameFilter));
//
//        return"allpatients";
//    }


    //*Save new Patient or update exists Patient*/
    @PostMapping
    public String addAndUpdatePatient(
            @Valid Patient patient,
            BindingResult bindingResult,
            Model model,
            @RequestParam("birthDates") String birthDate
    ){
        String lastnameFilter = null;
        String firstnameFilter = null;
        if(bindingResult.hasErrors() || birthDate.isEmpty()){
            if(birthDate.isEmpty()){model.addAttribute("birthDateError", "Please fill the correct date");}
            else{model.addAttribute("birthDateError", null);}
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("patients", patientService.patientList(lastnameFilter, firstnameFilter));
            model.addAttribute("patient", patient);
            model.addAttribute("birthDates", birthDate);

            return "allpatients";
        } else {
            patientService.save(patient, birthDate);
            model.addAttribute("patients", patientService.patientList(lastnameFilter, firstnameFilter));
            model.addAttribute("patient", null);

            return "redirect:allpatients";
        }
    }

}
