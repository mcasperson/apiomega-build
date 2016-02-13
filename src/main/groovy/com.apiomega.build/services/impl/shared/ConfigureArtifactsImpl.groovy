package com.apiomega.build.services.impl.shared

import com.apiomega.build.services.ConfigureArtifacts
import com.apiomega.build.services.impl.tasks.JavadocJarTask
import com.apiomega.build.services.impl.tasks.SourceJarTask
import org.gradle.api.Project

/**
 * Adds the source and javadoc jar tasks, configures some dependencies, and adds the archives to the
 * output of a build
 */
trait ConfigureArtifactsImpl implements ConfigureArtifacts {
    void configureArtifacts(Project project) {
        project.task('javadocJar', type: JavadocJarTask );
        project.task('sourceJar', type: SourceJarTask );

        project.artifacts {
            archives project.tasks.getByName('sourceJar')
            archives project.tasks.getByName('javadocJar')
        }

        project.getTasks().getByName("sourceJar").dependsOn(project.getTasks().getByName("classes"));
        project.getTasks().getByName("javadocJar").dependsOn(project.getTasks().getByName("javadoc"));
    }
}