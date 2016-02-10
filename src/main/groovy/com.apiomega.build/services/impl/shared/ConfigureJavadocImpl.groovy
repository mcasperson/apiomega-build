package com.apiomega.build.services.impl.shared

import com.apiomega.build.services.ConfigureJavadoc
import org.gradle.api.Project

/**
 * Prevent javadoc errors from failing the build
 */
trait ConfigureJavadocImpl implements ConfigureJavadoc {
    void configureJavadoc(Project project) {
        project.tasks.getByName('javadoc') {
            setFailOnError(false);
        }
    }

}