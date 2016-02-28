package com.apiomega.build.services.impl.apiwar

import com.apiomega.build.services.ConfigureDependencies
import org.gradle.api.Project

/**
 * Created by Matthew on 7/02/2016.
 */
trait ConfigureDependenciesImpl implements ConfigureDependencies {
    def apiOmegaVersion = "0.0.1-SNAPSHOT"
    def javaEEVersion = '7.0'

    void configureDependencies(Project project) {
        assert project != null;

        project.dependencies {
            providedCompile 'javax:javaee-api:' + javaEEVersion
            compile 'com.apiomega:apiomega:' + apiOmegaVersion
        }
    }
}