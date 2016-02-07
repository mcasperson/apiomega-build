package com.apiomega.build

import com.apiomega.build.services.impl.shared.ConfigureJavaVersionImpl
import com.apiomega.build.services.impl.shared.ConfigureMavenImpl
import com.apiomega.build.services.impl.shared.ConfigureWrapperImpl
import com.apiomega.build.services.impl.apiwar.ApplyPluginsImpl
import com.apiomega.build.services.impl.apiwar.ConfigureArtifactDetailsImpl
import com.apiomega.build.services.impl.apiwar.SonatypePublishingImpl
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A plugin to build the APIOmega RESTful interface war files
 */
class APIWar implements
        Plugin<Project>,
        ApplyPluginsImpl,
        ConfigureJavaVersionImpl,
        ConfigureMavenImpl,
        ConfigureArtifactDetailsImpl,
        SonatypePublishingImpl,
        ConfigureWrapperImpl {

    void apply(Project project) {
        applyPlugins(project);
        configureSonatypePublishing(project);
        configureArtifactDetails(project);
        configureJavaVersion(project);
        configureMaven(project);
        configureWrapper(project);
    }
}