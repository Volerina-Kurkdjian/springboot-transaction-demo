package com.example.springboot_transaction_demo.dto;

import com.example.springboot_transaction_demo.entity.Payment;
import com.example.springboot_transaction_demo.entity.Order;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class OrderRequest {

    private Order order;
    private Payment payment;




}
