package com.apiomega.build.services.impl.apiomegalibrary

import com.apiomega.build.services.ConfigureDependencies
import org.gradle.api.Project

/**
 * Created by Matthew on 7/02/2016.
 */
trait ConfigureDependenciesImpl implements ConfigureDependencies {
    void configureDependencies(Project project) {
        assert project != null;

        project.dependencies {
            provided 'javax:javaee-api:7.0'

            compile 'com.yahoo.elide:elide-core:' + elideVersion
            compile 'com.yahoo.elide:elide-datastore-inmemorydb:' + elideVersion
            compile 'org.apache.httpcomponents:httpclient:' + apacheHttpComponentsVersion
            compile 'org.apache.httpcomponents:httpmime:' + apacheHttpComponentsVersion
            compile 'commons-io:commons-io:' + apacheCommonsIoVersion
            compile 'com.google.guava:guava:' + googleGuavaVersion
            compile 'org.fourthline.cling:cling-core:' + clingVersion

            testCompile 'junit:junit:' + junitVersion
        }
    }
}