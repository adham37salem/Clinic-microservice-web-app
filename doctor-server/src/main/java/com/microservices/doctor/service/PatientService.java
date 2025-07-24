package com.microservices.doctor.service;

import com.microservices.doctor.model.dto.AddPatientDto;
import com.microservices.doctor.model.dto.PatientDto;
import com.microservices.doctor.proxy.PatientProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientProxy patientProxy;
    public PatientDto getPatient(Integer id) {
        return this.patientProxy.getPatient(id);
    }

    public AddPatientDto storePatient(@RequestBody AddPatientDto addPatientDto) {
        return this.patientProxy.storePatient(addPatientDto);
    }

}
