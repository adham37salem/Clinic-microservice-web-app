package com.microservices.payment.model.mapper;

import com.microservices.payment.model.dto.AddPaymentDto;
import com.microservices.payment.model.dto.PaymentDto;
import com.microservices.payment.model.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    // Show
    PaymentDto toPaymentDto(Payment payment);
    Payment toPayment(PaymentDto paymentDto);
    // Insert
    AddPaymentDto toAddPaymentDto(Payment addPaymentDto);
    Payment toAddPayment(AddPaymentDto addPaymentDto);
    // Get List
    List<PaymentDto> toPaymentDtoList(List<Payment> payments);
    List<Payment> toPaymentList(List<PaymentDto> paymentDtoList);
}
