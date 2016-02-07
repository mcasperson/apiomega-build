package com.apiomega.build.services.impl

import com.apiomega.build.services.ConfigureArtifactDetails
import org.gradle.api.Project

/**
 * An implementation that is shared across APIOmega projects to provide a way to configure the artifact details
 */
trait WebConfigureArtifactDetails implements ConfigureArtifactDetails {
    void configureArtifactDetails(Project project) {
        assert project != null;

        project.group = project.getProperties().get('Group')
        project.archivesBaseName = project.getProperties().get('ArchivesBaseName')
        project.version = project.getProperties().get('Version')
    }
}