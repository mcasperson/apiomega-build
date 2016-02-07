package com.apiomega.build

import com.apiomega.build.services.impl.build.BuildApplyPlugins
import com.apiomega.build.services.impl.build.BuildConfigureDependencies
import com.apiomega.build.services.impl.shared.ConfigureMavenImpl
import com.apiomega.build.services.impl.shared.ConfigureWrapperImpl
import com.apiomega.build.services.impl.apiwar.ConfigureArtifactDetailsImpl
import com.apiomega.build.services.impl.apiwar.SonatypePublishingImpl
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A plugin to build the APIOmega RESTful interface war files
 */
class Build implements
        Plugin<Project>,
        BuildApplyPlugins,
        ConfigureMavenImpl,
        ConfigureArtifactDetailsImpl,
        SonatypePublishingImpl,
        BuildConfigureDependencies,
        ConfigureWrapperImpl {

    void apply(Project project) {
        applyPlugins(project);
        configureSonatypePublishing(project);
        configureArtifactDetails(project);
        configureDependencies(project);
        configureMaven(project);
        configureWrapper(project);
    }
}