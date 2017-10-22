package com.felixsu.auth.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Created on 10/16/17.
 *
 * @author felixsoewito
 */
@Configuration
public class ServletCustomizer {

    @Bean
    public EmbeddedServletContainerCustomizer customizer() {
        return container -> {
            container.addErrorPages(
                    new ErrorPage(HttpStatus.UNAUTHORIZED, "/unauthenticated"));
        };
    }
}
