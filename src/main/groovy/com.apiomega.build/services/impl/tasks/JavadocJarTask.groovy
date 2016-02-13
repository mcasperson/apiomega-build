package com.apiomega.build.services.impl.tasks

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.javadoc.Javadoc
import org.gradle.jvm.tasks.Jar

/**
 * Created by Matthew on 7/02/2016.
 */
class JavadocJarTask extends Jar {

    @TaskAction
    def doAction() {
        classifier = 'javadoc'

        File file = ((Javadoc)project.tasks.getByName('javadoc')).getDestinationDir()

        from file
    }
}
