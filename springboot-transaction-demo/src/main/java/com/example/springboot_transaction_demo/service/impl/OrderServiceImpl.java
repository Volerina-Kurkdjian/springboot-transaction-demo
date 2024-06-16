package com.example.springboot_transaction_demo.service.impl;

import com.example.springboot_transaction_demo.dto.OrderRequest;
import com.example.springboot_transaction_demo.dto.OrderResponse;
import com.example.springboot_transaction_demo.entity.Order;
import com.example.springboot_transaction_demo.entity.Payment;
import com.example.springboot_transaction_demo.exception.PaymentException;
import com.example.springboot_transaction_demo.repository.OrderRepository;
import com.example.springboot_transaction_demo.repository.PaymentRepository;
import com.example.springboot_transaction_demo.service.OrderService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Transactional
@EnableTransactionManagement
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    @SneakyThrows
    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest)  {
        Order order=orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());

        orderRepository.save(order);
        Payment payment=orderRequest.getPayment();


        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type not supported!");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse=new OrderResponse();
        orderResponse.setOrderTrackingNumber(orderResponse.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS!");
        return orderResponse;
    }

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }
}
