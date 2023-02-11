package com.hhovhann.stripeintegration.service;

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

public interface StripeService {
  String BASE_URL = "https://91e7-46-70-240-240.eu.ngrok.io";
  String PRICE_ID = "price_1MaGKRDtQUXaCLrunJQdSZgY";

  /***
   * Create new Checkout Session for the order
   * Other optional params include:
   *  [billing_address_collection] - to display billing address details on the page
   *  [customer] - if you have an existing Stripe Customer ID
   *  [customer_email] - lets you prefill the email input in the form
   *  [automatic_tax] - to automatically calculate sales tax, VAT and GST in the checkout page
   *  For full details see https://stripe.com/docs/api/checkout/sessions/create
   *  ?session_id={CHECKOUT_SESSION_ID} means the redirect will have the session ID
   * @return Checkout Session
   *
   * @throws StripeException
   */
  Session createCheckoutSession() throws StripeException;
}
