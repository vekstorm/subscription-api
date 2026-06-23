package com.vekstorm.api.subscription.repositories;

import com.vekstorm.api.subscription.models.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SubscriptionRepository extends MongoRepository<Subscription, UUID> {
}
