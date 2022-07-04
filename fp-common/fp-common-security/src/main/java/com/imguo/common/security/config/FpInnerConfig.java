package com.imguo.common.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
@AllArgsConstructor
public class FpInnerConfig {
    private final HttpServletRequest request;

    @Bean
    public com.imguo.common.security.aop.FpInnerAopAspect hxInnerAopAspect() {
        return new com.imguo.common.security.aop.FpInnerAopAspect(request);
    }
}