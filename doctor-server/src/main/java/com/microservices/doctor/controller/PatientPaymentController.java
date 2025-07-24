package com.microservices.doctor.controller;

import com.microservices.doctor.model.dto.AddPaymentDto;
import com.microservices.doctor.model.dto.PaymentDto;
import com.microservices.doctor.service.PatientService;
import com.microservices.doctor.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PatientPaymentController {

    private final PaymentService paymentService;

    @GetMapping("/get-payment")
    public PaymentDto getPaymentByTranId(@RequestParam String tranId) {
        return this.paymentService.getPaymentByTranId(tranId);
    }

    @PostMapping("/add-payment")
    public PaymentDto addPayment(@RequestBody AddPaymentDto addPaymentDto) {
        return this.paymentService.addPayment(addPaymentDto);
    }
}
