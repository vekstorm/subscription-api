package com.vekstorm.api.subscription.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Document(collection = "subscriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    private String subscriptionName;

    private String type;

    @Builder.Default
    private Instant createdAt = Instant.now();

    @Builder.Default
    private boolean enabled = true;

    @Builder.Default
    private String subscriptionCode = UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
}
