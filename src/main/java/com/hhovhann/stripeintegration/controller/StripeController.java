package com.hhovhann.stripeintegration.controller;

import com.hhovhann.stripeintegration.service.StripeService;
import com.stripe.model.checkout.Session;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StripeController {
    private final StripeService stripeService;

    public StripeController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

  @PostMapping("/create-checkout-session")
  public String createPaymentIntent(HttpServletResponse response) throws Exception {
    Session session = stripeService.createCheckoutSession();
    response.setStatus(303);
    response.sendRedirect(session.getUrl());

    return "";
  }
}
