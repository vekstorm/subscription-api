package com.vekstorm.api.subscription.services;

import com.vekstorm.api.subscription.models.SubscriptionUsers;
import com.vekstorm.api.subscription.repositories.SubscriptionUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionUsersServiceImpl implements SubscriptionUsersService {

    private final SubscriptionUsersRepository subscriptionUsersRepository;

    @Override
    public List<SubscriptionUsers> findAll() {
        return subscriptionUsersRepository.findAll();
    }

    @Override
    public Optional<SubscriptionUsers> findById(UUID id) {
        return subscriptionUsersRepository.findById(id);
    }

    @Override
    public List<SubscriptionUsers> findBySubscriptionId(UUID subscriptionId) {
        return subscriptionUsersRepository.findBySubscriptionId(subscriptionId);
    }

    @Override
    public List<SubscriptionUsers> findByUserId(UUID userId) {
        return subscriptionUsersRepository.findByUserId(userId);
    }

    @Override
    public SubscriptionUsers save(SubscriptionUsers subscriptionUsers) {
        subscriptionUsers.setId(UUID.randomUUID());
        subscriptionUsers.setCreatedAt(Instant.now());
        return subscriptionUsersRepository.save(subscriptionUsers);
    }

    @Override
    public void deleteById(UUID id) {
        subscriptionUsersRepository.deleteById(id);
    }
}
