package com.apiomega.build.services.impl

import com.apiomega.build.services.ConfigureMaven
import org.gradle.api.Project
import org.gradle.api.tasks.bundling.Jar

/**
 * An implementation that is shared across APIOmega projects to configure the various
 * maven repos that we will be using
 */
trait SharedConfigureMaven implements ConfigureMaven {
    void configureMaven(Project project) {
        assert project != null;
        project.repositories {
            mavenCentral()
            maven {
                url 'http://4thline.org/m2'
            }
            maven {
                url 'https://oss.sonatype.org/content/repositories/snapshots'
            }
        }
    }
}