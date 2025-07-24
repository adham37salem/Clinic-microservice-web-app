package com.microservices.patient.service;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.PatientDto;
import com.microservices.patient.model.dto.PaymentDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PatientService {
    public AddPatientDTO store(AddPatientDTO  addPatientDTO);
    public AddPatientDTO update(AddPatientDTO addPatientDTO, Integer id);
    public String delete(Integer id);
    public PatientDto show(Integer id);
    public List<PaymentDto> getPatientPayments(Integer id);
}
