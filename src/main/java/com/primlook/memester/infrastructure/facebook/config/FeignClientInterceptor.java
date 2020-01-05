package com.primlook.memester.infrastructure.facebook.config;

import com.primlook.memester.security.UserPrincipal;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by Bernardo on 12/30/2019
 */
@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private static final String TOKEN_TYPE = "Bearer";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal) {
            UserPrincipal details = (UserPrincipal) authentication.getPrincipal();
            requestTemplate.header(HttpHeaders.AUTHORIZATION, String.format("%s %s", TOKEN_TYPE, details.getAccessToken()));
        }
    }
}
