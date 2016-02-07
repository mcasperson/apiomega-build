package com.apiomega.build

import com.apiomega.build.services.impl.SharedConfigureMaven
import com.apiomega.build.services.impl.WebApplyPlugins
import com.apiomega.build.services.impl.WebConfigureArtifactDetails
import com.apiomega.build.services.impl.WebSonatypePublishing
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A plugin to build the APIOmega RESTful interface war files
 */
class APIWar implements
        Plugin<Project>,
        WebApplyPlugins,
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