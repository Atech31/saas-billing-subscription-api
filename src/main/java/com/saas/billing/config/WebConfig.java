package com.saas.billing.config;

import com.saas.billing.security.TenantInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TenantInterceptor tenantInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Apply tenant interceptor to API routes (excluding public endpoints if needed)
        registry.addInterceptor(tenantInterceptor)
                .addPathPatterns("/api/v1/**");
    }
}
