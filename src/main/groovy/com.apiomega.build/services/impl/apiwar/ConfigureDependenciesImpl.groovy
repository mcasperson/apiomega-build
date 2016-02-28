package com.apiomega.build.services.impl.apiwar

import com.apiomega.build.services.ConfigureDependencies
import org.gradle.api.Project

/**
 * Created by Matthew on 7/02/2016.
 */
trait ConfigureDependenciesImpl implements ConfigureDependencies {
    def apiOmegaVersion = "0.0.2-SNAPSHOT"

    void configureDependencies(Project project) {
        assert project != null;

        project.dependencies {
            compile 'com.apiomega:apiomega:' + apiOmegaVersion
        }
    }
}