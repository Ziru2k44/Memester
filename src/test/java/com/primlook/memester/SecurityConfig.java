package com.primlook.memester;

import com.primlook.memester.security.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

/**
 * Created by Bernardo on 1/12/2020
 */
@Configuration
public class SecurityConfig {

    @MockBean
    CustomUserDetailsService customUserDetailsService;

    @MockBean
    CustomOAuth2UserService customOAuth2UserService;

    @MockBean
    OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @MockBean
    OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

    @MockBean
    TokenProvider tokenProvider;

    @MockBean
    ClientRegistrationRepository clientRegistrationRepository;
}
