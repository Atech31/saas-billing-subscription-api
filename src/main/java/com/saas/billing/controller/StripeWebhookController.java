package com.saas.billing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/webhooks")
public class StripeWebhookController {

    @PostMapping("/stripe")
    public ResponseEntity<String> handleStripeWebhook(
            @RequestBody String payload,
            @RequestHeader("Stripe-Signature") String sigHeader) {
        
        // TODO: In production, verify the Stripe signature using Stripe SDK
        // Stripe.apiKey = "your_secret_key";
        // Event event = Webhook.constructEvent(payload, sigHeader, endpointSecret);

        // Handle specific event types
        // if ("invoice.payment_succeeded".equals(event.getType())) { ... }
        // else if ("invoice.payment_failed".equals(event.getType())) { ... }

        System.out.println("Received Stripe Webhook Event Payload: " + payload);

        return ResponseEntity.ok("Webhook received successfully");
    }
}
