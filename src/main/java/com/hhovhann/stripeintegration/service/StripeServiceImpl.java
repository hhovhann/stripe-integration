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

    @Value("#{environment.STRIPE_SECRET_KEY}")
    private String stripeSecretKey;

    @PostConstruct
    public void init (){
        Stripe.apiKey = stripeSecretKey;
    }
    @Override
    public Session createCheckoutSession() throws StripeException {
        // set as a query param
        SessionCreateParams.Builder builder = new SessionCreateParams.Builder()
                .setSuccessUrl(BASE_URL + "/success.html?session_id={CHECKOUT_SESSION_ID}")
                .setCancelUrl(BASE_URL + "/canceled.html")
                // .setAutomaticTax(SessionCreateParams.AutomaticTax.builder().setEnabled(true).build())
                .setMode(SessionCreateParams.Mode.PAYMENT);

        // Add a line item for the sticker the Customer is purchasing
        SessionCreateParams.LineItem item = new SessionCreateParams.LineItem.Builder()
                .setQuantity(1L)
                .setPrice(PRICE_ID)
                .build();

        builder.addLineItem(item);

        SessionCreateParams createParams = builder.build();
        return Session.create(createParams);
    }
}
