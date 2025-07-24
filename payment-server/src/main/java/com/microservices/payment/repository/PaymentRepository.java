package com.microservices.payment.repository;

import com.microservices.payment.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Optional<Payment> findByTranId(String  tranId);
    List<Payment> findAllByPatientId(Integer patientId);

}
