package com.apiomega.build.services.impl

import com.apiomega.build.services.ConfigureDependencies
import org.gradle.api.Project

/**
 * Created by Matthew on 7/02/2016.
 */
trait BuildConfigureDependencies implements ConfigureDependencies {
    void configureDependencies(Project project) {
        assert project != null;

        project.dependencies {
            compile gradleApi()
            compile localGroovy()
        }
    }
}