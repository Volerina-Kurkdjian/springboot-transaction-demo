package com.example.springboot_transaction_demo.exception;

public class PaymentException extends Exception{

    public PaymentException(String message){
       super(message);
    }
}
