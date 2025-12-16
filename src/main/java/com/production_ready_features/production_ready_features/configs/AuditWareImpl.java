package com.production_ready_features.production_ready_features.configs;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditWareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Likitha Suresh");
    }
}
