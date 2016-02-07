package com.apiomega.build

import com.apiomega.build.services.impl.apiomegalibrary.ConfigureBuildScriptImpl
import com.apiomega.build.services.impl.apiomegalibrary.ConfigureDependenciesImpl
import com.apiomega.build.services.impl.shared.ConfigureJavaVersionImpl
import com.apiomega.build.services.impl.shared.ConfigureMavenImpl
import com.apiomega.build.services.impl.shared.ConfigureWrapperImpl
import com.apiomega.build.services.impl.apiwar.ApplyPluginsImpl
import com.apiomega.build.services.impl.apiwar.ConfigureArtifactDetailsImpl
import com.apiomega.build.services.impl.apiwar.SonatypePublishingImpl
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Matthew on 7/02/2016.
 */
class APIOmegaLibrary implements
        Plugin<Project>,
        ApplyPluginsImpl,
        ConfigureBuildScriptImpl,
        ConfigureJavaVersionImpl,
        ConfigureMavenImpl,
        ConfigureArtifactDetailsImpl,
        SonatypePublishingImpl,
        ConfigureWrapperImpl,
        ConfigureDependenciesImpl {

    void apply(Project project) {
        configureBuildScript(project);
        applyPlugins(project);
        configureSonatypePublishing(project);
        configureArtifactDetails(project);
        configureJavaVersion(project);
        configureMaven(project);
        configureWrapper(project);
        configureDependencies(project);
    }
}