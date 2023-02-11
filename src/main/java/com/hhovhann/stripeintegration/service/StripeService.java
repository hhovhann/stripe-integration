package com.hhovhann.stripeintegration.service;

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

public interface StripeService {
    Session createCheckoutSession() throws StripeException;
}
