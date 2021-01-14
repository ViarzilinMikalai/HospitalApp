package org.viarzilin.hospital.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.viarzilin.hospital.domain.Patient;
import org.viarzilin.hospital.services.PatientService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    public final PatientService patientService;

    /**Output patients List and Search patients by Filters*/

    @GetMapping
    public String allPatients(
            Patient patient,
            @RequestParam(required = false, defaultValue = "") String lastnameFilter,
            @RequestParam(required = false, defaultValue = "") String firstnameFilter,
            Model model,
            @RequestParam(required = false, defaultValue = "") Patient removePatient,
            @PageableDefault(sort = {"lastname"}, direction = Sort.Direction.ASC) Pageable pageable
    ){
        if (removePatient != null){
            patientService.remove(removePatient);
        }

        Page<Patient> page = patientService.patientList(lastnameFilter, firstnameFilter, pageable);
        model.addAttribute ("page", page);
        model.addAttribute("url", "/patients");
        model.addAttribute("lastnameFilter", lastnameFilter);
        model.addAttribute("firstnameFilter", firstnameFilter);
        model.addAttribute("bodyForPager", ControllerUtils.pagerUtil(page));

        return "patients";
    }


    /**Save new Patient or update exists Patient*/
    @PostMapping
    public String addPatient(
            @Valid Patient patient,
            @RequestParam(required = false, defaultValue = "") String lastnameFilter,
            @RequestParam(required = false, defaultValue = "") String firstnameFilter,
            BindingResult bindingResult,
            Model model,
            @PageableDefault(sort = {"lastname"}, direction = Sort.Direction.ASC) Pageable pageable
    ){
        Page<Patient> page = patientService.patientList(lastnameFilter, firstnameFilter, pageable);
        model.addAttribute ("page", page);
        model.addAttribute("url", "/patients");
        model.addAttribute("bodyForPager", ControllerUtils.pagerUtil(page));

        if(bindingResult.hasErrors()){
            model.addAttribute("patient", patient);
            return "patients";
        } else {
            patientService.save(patient);
            return "redirect:patients";
        }
    }


    @GetMapping("{id}/edit")
    public String editPatients(
            Model model,
            @PageableDefault(sort = {"lastname"}, direction = Sort.Direction.ASC) Pageable pageable,
            @PathVariable(value = "id", required = false) Patient oldPatient
    ){
        model.addAttribute("patient", oldPatient);

        return "edit";
    }


    @PostMapping("/{id}/edit")
    public String editPatient(
            @Valid Patient patient,
            BindingResult bindingResult,
            Model model,
            @PageableDefault(sort = {"lastname"}, direction = Sort.Direction.ASC) Pageable pageable,
            @PathVariable(value = "id", required = false) Patient oldPatient
    ){
        if(bindingResult.hasErrors()){
            model.addAttribute("patient", patient);
            return "edit";
        } else {
            patientService.edit(patient, oldPatient);
            return "redirect:/patients";
        }
    }


}
