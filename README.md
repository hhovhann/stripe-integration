# stripe-integration
Demo project for Spring Boot Stripe Integration

### How Configure And Run Application
* Create application from stripe developer to use the STRIPE_PUBLIC_KEY, STRIPE_SECRET_KEY
* Add environment variables STRIPE_PUBLIC_KEY(publishable key) and STRIPE_SECRET_KEY (secret key) from [Strip Dashboard](https://dashboard.stripe.com/test/apikeys)
* Run from IDEA or run script/run.sh

### Apple Pay, Google Pay, Link
Please check and following the section [Prerequisites](https://stripe.com/docs/stripe-js/elements/payment-request-button?client=html#html-js-prerequisites)

### Testing
[Testing Interactively](https://stripe.com/docs/testing#testing-interactively)

#### Testing cards
* 4242424242424242 success
* 4000000000000002 decline
* 4000000000003220 authentication


### References
[Payment Request Button](https://stripe.com/docs/stripe-js/elements/payment-request-button)
[Accept payments with Stripe Checkout](https://github.com/stripe-samples/checkout-one-time-payments)
[Accept an Apple Pay payment with Stripe.js](https://www.youtube.com/watch?v=5KcdQboA7Gc)
[Live Coding #1: Stripe payment integration - By @MarcoCodes](https://www.youtube.com/watch?v=BIDNKRluql4)


### Troubleshooting
* Apple Pay -  when testing web be sure that you have added your card to Apple Wallet [Set up Apple Pay](https://support.apple.com/en-us/HT204506)
* Google Pay -  when testing web be sure that you have added your card to Google Wallet [Add a debit or credit card](https://support.google.com/wallet/answer/12058983?hl=en)
* Google Pay -  when testing web be sure that you have added your card to Google Wallet [Fill out forms automatically](https://support.google.com/chrome/answer/142893?hl=en&co=GENIE.Platform%3DDesktop)