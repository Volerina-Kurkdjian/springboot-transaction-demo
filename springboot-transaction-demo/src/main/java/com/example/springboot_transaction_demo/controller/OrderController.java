package com.example.springboot_transaction_demo.controller;

import com.example.springboot_transaction_demo.dto.OrderRequest;
import com.example.springboot_transaction_demo.dto.OrderResponse;
import com.example.springboot_transaction_demo.exception.PaymentException;
import com.example.springboot_transaction_demo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) throws PaymentException {
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }



}
