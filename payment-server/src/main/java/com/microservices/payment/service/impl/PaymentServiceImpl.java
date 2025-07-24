package com.microservices.payment.service.impl;

import com.microservices.payment.model.dto.AddPaymentDto;
import com.microservices.payment.model.dto.PaymentDto;
import com.microservices.payment.model.entity.Payment;
import com.microservices.payment.model.mapper.PaymentMapper;
import com.microservices.payment.repository.PaymentRepository;
import com.microservices.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;
    @Override
    public PaymentDto getPayment(String tranId) {
        Optional<Payment> payment = this.paymentRepository.findByTranId(tranId);
        return this.paymentMapper.toPaymentDto(payment.get());
    }

    @Override
    public PaymentDto addPayment(AddPaymentDto addPaymentDto) {
        String tranId = UUID.randomUUID().toString();
        PaymentDto paymentDto = PaymentDto.builder()
                .amount(addPaymentDto.getAmount())
                .tranId(tranId)
                .patientId(addPaymentDto.getPatientId())
                .build();
        Payment entity = this.paymentMapper.toPayment(paymentDto);
        Payment payment = this.paymentRepository.save(entity);
        return this.paymentMapper.toPaymentDto(payment);
    }

    @Override
    public List<PaymentDto> getPatientPayments(Integer patientId) {
         List<Payment> payments = this.paymentRepository.findAllByPatientId(patientId);
         return this.paymentMapper.toPaymentDtoList(payments);
    }
}
