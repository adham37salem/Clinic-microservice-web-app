package com.microservices.patient.model.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.PatientDto;
import com.microservices.patient.model.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toEntity(PatientDto patientDto);
    PatientDto toDto(Patient patient);
    AddPatientDTO toAddDto(Patient patient);
    Patient toAddEntity(AddPatientDTO patientDTO);
    // Update via ID
    void toUpdateEntity(AddPatientDTO patientDTO, @MappingTarget Patient patient);

}
