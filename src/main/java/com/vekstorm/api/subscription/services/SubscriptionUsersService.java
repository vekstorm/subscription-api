package com.vekstorm.api.subscription.services;

import com.vekstorm.api.subscription.models.SubscriptionUsers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubscriptionUsersService {

    List<SubscriptionUsers> findAll();

    Optional<SubscriptionUsers> findById(UUID id);

    List<SubscriptionUsers> findBySubscriptionId(UUID subscriptionId);

    List<SubscriptionUsers> findByUserId(UUID userId);

    SubscriptionUsers save(SubscriptionUsers subscriptionUsers);

    void deleteById(UUID id);
}
