package com.microservices.doctor.service;

import com.microservices.doctor.model.dto.AddPaymentDto;
import com.microservices.doctor.model.dto.PaymentDto;
import com.microservices.doctor.proxy.PatientProxy;
import com.microservices.doctor.proxy.PaymentProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentProxy paymentProxy;

    public PaymentDto getPaymentByTranId(String tranId) {
        return this.paymentProxy.getPaymentByTranId(tranId);
    }

    public PaymentDto addPayment(AddPaymentDto addPaymentDto) {
        return this.paymentProxy.addPayment(addPaymentDto);
    }
}
