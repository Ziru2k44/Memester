package com.primlook.memester.config;

import com.primlook.memester.domain.util.UserAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by Bernardo on 1/29/2020
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class PersistenceConfig {

    @Bean
    AuditorAware<String> auditorProvider() {
        return new UserAuditorAware();
    }
}
