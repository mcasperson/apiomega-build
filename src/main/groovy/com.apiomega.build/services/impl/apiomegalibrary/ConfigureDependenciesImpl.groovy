package com.apiomega.build.services.impl.apiomegalibrary

import com.apiomega.build.services.ConfigureDependencies
import org.gradle.api.Project

/**
 * Created by Matthew on 7/02/2016.
 */
trait ConfigureDependenciesImpl implements ConfigureDependencies {
    def elideVersion = '1.0.0.19'
    def apacheHttpComponentsVersion = '4.5.1'
    def apacheCommonsIoVersion = '2.4'
    def googleGuavaVersion = '19.0'
    def clingVersion = '2.0.1'
    def junitVersion = '4.12'

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