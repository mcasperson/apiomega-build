package com.apiomega.build

import com.apiomega.build.services.impl.apiomegalibrary.ConfigureDependenciesImpl
import com.apiomega.build.services.impl.apiomegalibrary.ApplyPluginsImpl
import com.apiomega.build.services.impl.shared.ConfigureJavaVersionImpl
import com.apiomega.build.services.impl.shared.ConfigureMavenImpl
import com.apiomega.build.services.impl.shared.ConfigureWrapperImpl
import com.apiomega.build.services.impl.shared.SonatypePublishingImpl
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Matthew on 7/02/2016.
 */
class APIOmegaLibrary implements
        Plugin<Project>,
        ApplyPluginsImpl,
        ConfigureJavaVersionImpl,
        ConfigureMavenImpl,
        SonatypePublishingImpl,
        ConfigureWrapperImpl,
        ConfigureDependenciesImpl {

    void apply(Project project) {
        applyPlugins(project);
        configureDependencies(project);
        configureSonatypePublishing(project);
        configureJavaVersion(project);
        configureMaven(project);
        configureWrapper(project);

    }
}