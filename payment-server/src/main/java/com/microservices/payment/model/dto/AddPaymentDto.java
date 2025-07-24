package com.microservices.payment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPaymentDto {
    private String tranId;
    private Integer patientId;
    private Double amount;
}
