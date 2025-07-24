package com.microservices.patient.controller;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.PatientDto;
import com.microservices.patient.model.dto.PaymentDto;
import com.microservices.patient.service.Impl.PatientServiceImpl;
import com.microservices.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
// We use it for Logging Information
@Slf4j
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/")
    public AddPatientDTO store(@RequestBody AddPatientDTO addPatientDTO) {
        return this.patientService.store(addPatientDTO);
    }

    @PatchMapping("/{id}")
    public AddPatientDTO update(@RequestBody AddPatientDTO addPatientDTO,  @PathVariable("id") Integer id) {
        return this.patientService.update(addPatientDTO, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        return this.patientService.delete(id);
    }

    @GetMapping("/{id}")
    public PatientDto show(@PathVariable("id")  Integer id) {
        return this.patientService.show(id);
    }

    @GetMapping("/get-patient-payments/{id}")
    public List<PaymentDto> getPatientPayments(@PathVariable("id") Integer id) {
        return this.patientService.getPatientPayments(id);
    }

}
