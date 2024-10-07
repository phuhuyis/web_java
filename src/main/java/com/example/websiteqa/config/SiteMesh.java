package com.example.websiteqa.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SiteMesh extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/admin/*","/decorators/admin.jsp")
                .addDecoratorPath("/admin*","/decorators/admin.jsp")
                .addExcludedPath("/api/**")
                .addExcludedPath("/login*")
                .addExcludedPath("/login/*")
                .addExcludedPath("/register*")
                .addExcludedPath("/register/*")
                .addExcludedPath("/admin/login*")
                .addExcludedPath("/admin/login/*")
                .addDecoratorPath("/*","/decorators/client.jsp")
                .addDecoratorPath("*","/decorators/client.jsp");
    }
}
