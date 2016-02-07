package com.apiomega.build.services.impl

import com.apiomega.build.services.ApplyPlugins
import org.gradle.api.Project

/**
 * Created by Matthew on 23/01/2016.
 */
trait WebApplyPlugins implements ApplyPlugins {
    void applyPlugins(Project project) {
        assert project != null;
        project.plugins.apply('war');
        project.plugins.apply('maven');
        project.plugins.apply('maven-publishing');
        project.plugins.apply('signing')
    }
}