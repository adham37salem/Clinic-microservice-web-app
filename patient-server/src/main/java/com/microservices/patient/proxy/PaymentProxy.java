package com.microservices.patient.proxy;

import com.microservices.patient.model.dto.PaymentDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "PAYMENT-SERVICE", url = "http://localhost:7000", path = "/payment")
public interface PaymentProxy {
    @GetMapping("/payment/get-patient-payments/{id}")
    List<PaymentDto> getPatientPayments(@PathVariable("id") Integer id);
}
