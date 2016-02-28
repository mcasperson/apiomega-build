package com.apiomega.build.services.impl.apiomegalibrary

import com.apiomega.build.services.ConfigureDependencies
import org.gradle.api.Project

/**
 * Created by Matthew on 7/02/2016.
 */
trait ConfigureDependenciesImpl implements ConfigureDependencies {
    def hydraSpringVersion = '0.2.0-beta3'
    def apacheHttpComponentsVersion = '4.5.1'
    def apacheCommonsIoVersion = '2.4'
    def googleGuavaVersion = '19.0'
    def clingVersion = '2.0.1'
    def junitVersion = '4.12'
    def javaEEVersion = '7.0'

    void configureDependencies(Project project) {
        assert project != null;

        project.dependencies {
            providedCompile 'javax:javaee-api:' + javaEEVersion

            compile 'de.escalon.hypermedia:hydra-spring:' + hydraSpringVersion
            compile 'org.apache.httpcomponents:httpclient:' + apacheHttpComponentsVersion
            compile 'org.apache.httpcomponents:httpmime:' + apacheHttpComponentsVersion
            compile 'commons-io:commons-io:' + apacheCommonsIoVersion
            compile 'com.google.guava:guava:' + googleGuavaVersion
            compile 'org.fourthline.cling:cling-core:' + clingVersion

            testCompile 'junit:junit:' + junitVersion
        }
    }
}