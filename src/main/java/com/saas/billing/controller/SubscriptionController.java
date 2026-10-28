package com.saas.billing.controller;

import com.saas.billing.model.Subscription;
import com.saas.billing.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping
    public ResponseEntity<List<Subscription>> getSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getTenantSubscriptions());
    }

    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestParam Long planId) {
        return ResponseEntity.ok(subscriptionService.createSubscription(planId));
    }
}
