package com.vekstorm.api.subscription.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Document(collection = "subscription_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionUsers {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    private UUID subscriptionId;

    private UUID userId;

    @Builder.Default
    private Instant createdAt = Instant.now();
}
