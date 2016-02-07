package com.apiomega.build.services.impl.shared

import com.apiomega.build.services.ConfigureJavaVersion
import org.gradle.api.Project

/**
 * Created by Matthew on 7/02/2016.
 */
trait ConfigureJavaVersionImpl implements ConfigureJavaVersion {
    void configureJavaVersion(Project project) {
        project.sourceCompatibility = 1.8;
        project.targetCompatibility = 1.8;
    }
}