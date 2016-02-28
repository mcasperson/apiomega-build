package com.apiomega.build.services.impl.apiwar

import com.apiomega.build.services.ConfigureDependencies
import org.gradle.api.Project

/**
 * Defines the dependencies to be applied to WAR based API applications
 */
trait ConfigureDependenciesImpl implements ConfigureDependencies {
    def apiOmegaVersion = "0.0.5-SNAPSHOT";
    def swaggerVersion = "1.5.0";

    void configureDependencies(Project project) {
        assert project != null;

        project.dependencies {
            compile 'com.apiomega:apiomega:' + apiOmegaVersion
            compile 'io.swagger:swagger-jaxrs:' + swaggerVersion
        }
    }
}