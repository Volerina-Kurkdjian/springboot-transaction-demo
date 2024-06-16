package com.example.springboot_transaction_demo.repository;

import com.example.springboot_transaction_demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {


}
