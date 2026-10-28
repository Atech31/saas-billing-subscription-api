package com.saas.billing.repository;

import com.saas.billing.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByTenantId(String tenantId);
    Optional<Subscription> findByTenantIdAndStatus(String tenantId, String status);
}
