package com.vekstorm.api.subscription.services;

import com.vekstorm.api.subscription.models.Subscription;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubscriptionService {

    List<Subscription> findAll();

    Optional<Subscription> findById(UUID id);

    Subscription save(Subscription subscription);

    Subscription update(UUID id, Subscription subscription);

    void deleteById(UUID id);
}
