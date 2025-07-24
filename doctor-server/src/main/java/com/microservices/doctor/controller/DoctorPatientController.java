package com.microservices.doctor.controller;

import com.microservices.doctor.model.dto.AddPatientDto;
import com.microservices.doctor.model.dto.PatientDto;
import com.microservices.doctor.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorPatientController {
    private final PatientService patientService;

    @GetMapping("/get-patient/{id}")
    public PatientDto getPatient(@PathVariable("id")  Integer id) {
        return this.patientService.getPatient(id);
    }

    @PostMapping("/store-patient")
    public AddPatientDto storePatient(@RequestBody AddPatientDto addPatientDto) {
        return this.patientService.storePatient(addPatientDto);
    }
}
