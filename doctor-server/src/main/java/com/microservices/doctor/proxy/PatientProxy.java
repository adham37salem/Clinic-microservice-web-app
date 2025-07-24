package com.microservices.doctor.proxy;

import com.microservices.doctor.model.dto.AddPatientDto;
import com.microservices.doctor.model.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PATIENT-SERVICE", url = "http://localhost:8000", path = "/patient")
public interface PatientProxy {

    @GetMapping(value = "/patients/{id}", produces = "application/json")
    public PatientDto getPatient(@PathVariable("id") Integer id);

    @PostMapping(value = "/patients/", produces = "application/json")
    public AddPatientDto storePatient(@RequestBody AddPatientDto addPatientDto);
}
