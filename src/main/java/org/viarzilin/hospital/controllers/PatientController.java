package org.viarzilin.hospital.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.viarzilin.hospital.domain.Patient;
import org.viarzilin.hospital.services.PatientService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**Output patients List and Search patients by Filters*/
    @GetMapping
    public String allPatients(
            @RequestParam(required = false, defaultValue = "") String lastnameFilter,
            @RequestParam(required = false, defaultValue = "") String firstnameFilter,
            Model model,
            @RequestParam(required = false, defaultValue = "") Patient removePatient,
            @RequestParam(required = false, defaultValue = "") Patient reparePatient,
            @RequestParam(value = "patient", required = false) Patient patient,
            @PageableDefault(sort = {"lastname"}, direction = Sort.Direction.ASC) Pageable pageable
    ){

        if (removePatient != null){
            patientService.remove(removePatient);
        }

        if (reparePatient != null){
            patientService.repare(reparePatient);
        }

        Page<Patient> page = patientService.patientList(lastnameFilter, firstnameFilter, pageable);
        model.addAttribute ("page", page);
        model.addAttribute("url", "/patients");
        model.addAttribute("lastnameFilter", lastnameFilter);
        model.addAttribute("firstnameFilter", firstnameFilter);

        if (patient != null) {
            model.addAttribute("patient", patient);
            model.addAttribute("birthDates", patient.getBirthDate());
        }

        return "patients";
    }


    /**Save new Patient or update exists Patient*/
    @PostMapping
    public String addOrUpdatePatient(
            @Valid Patient patient,
            BindingResult bindingResult,
            Model model,
            @RequestParam("birthDates") String birthDate,
            @PageableDefault(sort = {"lastname"}, direction = Sort.Direction.ASC) Pageable pageable
    ){
        String lastnameFilter = null;
        String firstnameFilter = null;
        Page<Patient> page = patientService.patientList(lastnameFilter, firstnameFilter, pageable);
        model.addAttribute ("page", page);
        model.addAttribute("url", "/patients");

        if (!birthDate.isEmpty()){
            patient.setBirthDate(LocalDate.parse(birthDate));
        }

        if(bindingResult.hasErrors() || birthDate.isEmpty()){

            if(birthDate.isEmpty()){

                model.addAttribute("birthDateError", "Please fill the correct date");

            } else {

                model.addAttribute("birthDateError", null);
            }

            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("patient", patient);
            model.addAttribute("birthDates", patient.getBirthDate());

            return "patients";

        } else {

            if (!patientService.save(patient)){

                model.addAttribute("savingReport", "Patient is Exists");
                return "patients";

            } else {

                model.addAttribute("patient", null);
                return "redirect:patients";

            }
        }
    }
}
