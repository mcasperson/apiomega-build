package com.apiomega.build.services.impl.shared

import com.apiomega.build.services.ConfigureWrapper
import org.gradle.api.Project
import org.gradle.api.tasks.wrapper.Wrapper

/**
 * Created by Matthew on 7/02/2016.
 */
trait ConfigureWrapperImpl implements ConfigureWrapper {
    void configureWrapper(Project project) {
        project.task('wrapper', type: Wrapper) {
            setGradleVersion('2.10')
        }
    }
}