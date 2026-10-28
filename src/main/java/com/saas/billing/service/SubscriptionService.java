package com.saas.billing.service;

import com.saas.billing.model.Subscription;
import com.saas.billing.model.SubscriptionPlan;
import com.saas.billing.repository.SubscriptionPlanRepository;
import com.saas.billing.repository.SubscriptionRepository;
import com.saas.billing.security.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionPlanRepository planRepository;

    public List<Subscription> getTenantSubscriptions() {
        String tenantId = TenantContext.getCurrentTenant();
        return subscriptionRepository.findByTenantId(tenantId);
    }

    public Subscription createSubscription(Long planId) {
        String tenantId = TenantContext.getCurrentTenant();
        
        SubscriptionPlan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Subscription plan not found"));

        Subscription subscription = Subscription.builder()
                .tenantId(tenantId)
                .plan(plan)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusMonths(1)) // default 1 month
                .status("ACTIVE")
                .build();

        return subscriptionRepository.save(subscription);
    }
}
