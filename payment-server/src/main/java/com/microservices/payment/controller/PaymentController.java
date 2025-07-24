package com.microservices.payment.controller;

import com.microservices.payment.model.dto.AddPaymentDto;
import com.microservices.payment.model.dto.PaymentDto;
import com.microservices.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/get-payment")
    public PaymentDto getPaymentByTranId(@RequestParam String tranId) {
        return this.paymentService.getPayment(tranId);
    }

    @PostMapping("/add-payment")
    public PaymentDto addPayment(@RequestBody AddPaymentDto addPaymentDto) {
        return this.paymentService.addPayment(addPaymentDto);
    }

    @GetMapping("/get-patient-payments/{id}")
    public List<PaymentDto> getPatientPayments(@PathVariable("id") Integer id) {
        return this.paymentService.getPatientPayments(id);
    }
}
