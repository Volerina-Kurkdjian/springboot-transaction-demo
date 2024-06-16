package com.example.springboot_transaction_demo.service;

import com.example.springboot_transaction_demo.dto.OrderRequest;
import com.example.springboot_transaction_demo.dto.OrderResponse;
import com.example.springboot_transaction_demo.exception.PaymentException;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
