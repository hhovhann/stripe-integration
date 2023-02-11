package com.hhovhann.stripeintegration.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StripeServiceImpl implements StripeService {
    private final String BASE_URL = "https://91e7-46-70-240-240.eu.ngrok.io";

    @Value("#{environment.STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @Value("#{environment.STRIPE_SECRET_KEY}")
    private String stripeSecretKey;

    @PostConstruct
    public void init (){
        Stripe.apiKey = stripeSecretKey;
    }
    @Override
    public Session createCheckoutSession() throws StripeException {
        // Create new Checkout Session for the order
        // Other optional params include:
        // [billing_address_collection] - to display billing address details on the page
        // [customer] - if you have an existing Stripe Customer ID
        // [customer_email] - lets you prefill the email input in the form
        // [automatic_tax] - to automatically calculate sales tax, VAT and GST in the checkout page
        // For full details see https://stripe.com/docs/api/checkout/sessions/create

        // ?session_id={CHECKOUT_SESSION_ID} means the redirect will have the session ID
        // set as a query param
        SessionCreateParams.Builder builder = new SessionCreateParams.Builder()
                .setSuccessUrl(BASE_URL + "/success.html?session_id={CHECKOUT_SESSION_ID}")
                .setCancelUrl(BASE_URL + "/canceled.html")
                // .setAutomaticTax(SessionCreateParams.AutomaticTax.builder().setEnabled(true).build())
                .setMode(SessionCreateParams.Mode.PAYMENT);

        // Add a line item for the sticker the Customer is purchasing
        SessionCreateParams.LineItem item = new SessionCreateParams.LineItem.Builder()
                .setQuantity(1L)
                .setPrice("price_1MaGKRDtQUXaCLrunJQdSZgY")
                .build();

        builder.addLineItem(item);

        SessionCreateParams createParams = builder.build();
        return Session.create(createParams);
    }
}
