package com.vekstorm.api.subscription.controllers;

import com.vekstorm.api.subscription.models.SubscriptionUsers;
import com.vekstorm.api.subscription.services.SubscriptionUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/subscription-users", produces = "application/json")
@RequiredArgsConstructor
public class SubscriptionUsersController {

    private final SubscriptionUsersService subscriptionUsersService;

    @GetMapping
    @PreAuthorize("hasAuthority('subscription:read')")
    public ResponseEntity<List<SubscriptionUsers>> getAll(
            @RequestParam(required = false) UUID subscriptionId,
            @RequestParam(required = false) UUID userId) {

        if (subscriptionId != null) {
            return ResponseEntity.ok(subscriptionUsersService.findBySubscriptionId(subscriptionId));
        }
        if (userId != null) {
            return ResponseEntity.ok(subscriptionUsersService.findByUserId(userId));
        }
        return ResponseEntity.ok(subscriptionUsersService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('subscription:read')")
    public ResponseEntity<SubscriptionUsers> getById(@PathVariable UUID id) {
        return subscriptionUsersService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('subscription:write')")
    public ResponseEntity<SubscriptionUsers> create(@RequestBody SubscriptionUsers subscriptionUsers) {
        SubscriptionUsers saved = subscriptionUsersService.save(subscriptionUsers);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('subscription:write')")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        subscriptionUsersService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
