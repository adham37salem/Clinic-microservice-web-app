package com.microservices.payment.service;

import com.microservices.payment.model.dto.AddPaymentDto;
import com.microservices.payment.model.dto.PaymentDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PaymentService {
    public PaymentDto getPayment(String tranId);
    public PaymentDto addPayment(AddPaymentDto addPaymentDto);
    public List<PaymentDto> getPatientPayments(Integer patientId);
}
