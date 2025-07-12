package com.example.spring_boot_ecommerce.service;

import com.example.spring_boot_ecommerce.dto.Purchase;
import com.example.spring_boot_ecommerce.dto.PaymentInfo;

import com.example.spring_boot_ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
