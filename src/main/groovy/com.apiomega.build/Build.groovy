package com.apiomega.build

import com.apiomega.build.services.impl.BuildApplyPlugins
import com.apiomega.build.services.impl.SharedConfigureMaven
import com.apiomega.build.services.impl.WebConfigureArtifactDetails
import com.apiomega.build.services.impl.WebSonatypePublishing
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A plugin to build the APIOmega RESTful interface war files
 */
class Build implements
        Plugin<Project>,
        BuildApplyPlugins,
        SharedConfigureMaven,
        WebConfigureArtifactDetails,
        WebSonatypePublishing {

    void apply(Project project) {
        applyPlugins(project); ;
        configureMaven(project);
        configureArtifactDetails(project);
        configureSonatypePublishing(project);
    }
}