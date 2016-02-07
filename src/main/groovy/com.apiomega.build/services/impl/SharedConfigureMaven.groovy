package com.apiomega.build.services.impl

import com.apiomega.build.services.ConfigureMaven
import org.gradle.api.Project

/**
 * An implementation that is shared across APIOmega projects to configure the various
 * maven repos that we will be using
 */
trait SharedConfigureMaven implements ConfigureMaven {
    void configureMaven(Project project) {
        assert project != null;
        project.repositories.maven {
            mavenCentral()
            maven {
                url 'http://4thline.org/m2'
            }
            maven {
                url 'https://oss.sonatype.org/content/repositories/snapshots'
            }
        }

        project.task('javadocJar', 'Jar') {
            classifier = 'javadoc'
            from javadoc
        }

        project.task('sourcesJar', 'Jar') {
            classifier = 'sources'
            from sourceSets.main.allSource
        }

        project.artifacts {
            archives javadocJar, sourcesJar
        }

        project.signing {
            sign configurations.archives
        }
    }
}