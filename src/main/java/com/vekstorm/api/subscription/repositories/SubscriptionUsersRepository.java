package com.vekstorm.api.subscription.repositories;

import com.vekstorm.api.subscription.models.SubscriptionUsers;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface SubscriptionUsersRepository extends MongoRepository<SubscriptionUsers, UUID> {

    List<SubscriptionUsers> findBySubscriptionId(UUID subscriptionId);

    List<SubscriptionUsers> findByUserId(UUID userId);
}
