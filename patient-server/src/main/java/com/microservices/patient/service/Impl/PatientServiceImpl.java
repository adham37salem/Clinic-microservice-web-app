package com.microservices.patient.service.Impl;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.PatientDto;
import com.microservices.patient.model.dto.PaymentDto;
import com.microservices.patient.model.entity.Patient;
import com.microservices.patient.model.mapper.PatientMapper;
import com.microservices.patient.proxy.PaymentProxy;
import com.microservices.patient.repository.PatientRepository;
import com.microservices.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final PaymentProxy paymentProxy;

    @Override
    public AddPatientDTO store(AddPatientDTO addPatientDTO) {

        Patient patient = this.patientMapper.toAddEntity(addPatientDTO);
        Patient newPatient = this.patientRepository.save(patient);
        return this.patientMapper.toAddDto(newPatient);


    }

    @Override
    public AddPatientDTO update(AddPatientDTO addPatientDTO, Integer id) {
        Patient existingPatient = this.patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient Not Found"));
        this.patientMapper.toUpdateEntity(addPatientDTO, existingPatient);
        Patient updatedPatient = this.patientRepository.save(existingPatient);
        return this.patientMapper.toAddDto(updatedPatient);
    }

    @Override
    public String delete(Integer id) {
        this.patientRepository.deleteById(id);
        return "Patient is deleted Successfully ";
    }

    @Override
    public PatientDto show(Integer id) {
        Optional<Patient> patient = this.patientRepository.findById(id);
        return this.patientMapper.toDto(patient.get());
    }

    @Override
    public List<PaymentDto> getPatientPayments(Integer id) {
        return this.paymentProxy.getPatientPayments(id);
    }

}
