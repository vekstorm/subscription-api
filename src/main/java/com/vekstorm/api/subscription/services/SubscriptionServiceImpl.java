package com.vekstorm.api.subscription.services;

import com.vekstorm.api.subscription.models.Subscription;
import com.vekstorm.api.subscription.repositories.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> findById(UUID id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public Subscription save(Subscription subscription) {
        subscription.setId(UUID.randomUUID());
        subscription.setCreatedAt(Instant.now());
        subscription.setSubscriptionCode(UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase());
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription update(UUID id, Subscription subscription) {
        return subscriptionRepository.findById(id)
                .map(existing -> {
                    existing.setSubscriptionName(subscription.getSubscriptionName());
                    existing.setType(subscription.getType());
                    existing.setEnabled(subscription.isEnabled());
                    return subscriptionRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Subscription not found with id: " + id));
    }

    @Override
    public void deleteById(UUID id) {
        subscriptionRepository.deleteById(id);
    }
}
