package com.apiomega.build.services.impl

import com.apiomega.build.services.SonatypePublishing
import com.apiomega.build.services.impl.tasks.JavadocJarTask
import com.apiomega.build.services.impl.tasks.SourceJarTask
import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPublication

/**
 * An implementation that is shared across APIOmega projects to provide a way to publish to Sonatype
 * see http://mike-neck.github.io/blog/2013/06/21/how-to-publish-artifacts-with-gradle-maven-publish-plugin-version-1-dot-6/
 * for more details.
 */
trait WebSonatypePublishing implements SonatypePublishing {
    void configureSonatypePublishing(Project project) {
        assert project != null;
        assert project.hasProperty('ossrhUsername') : 'You need to define the ossrhUsername property in the gradle.properties file'
        assert project.hasProperty('ossrhPassword') : 'You need to define the ossrhPassword property in the gradle.properties file'

        project.signing {
            sign project.configurations.archives
        }

        project.task('javadocJar', type: JavadocJarTask );
        project.task('sourceJar ', type: SourceJarTask );

        project.publishing {
            publications {
                mavenJava(MavenPublication) {

                    getPom().withXml {
                        def root = asNode()
                        root.appendNode('name', project.getProperties().get('MavenName'))
                        root.appendNode('description', project.getProperties().get('MavenDescription'))
                        root.appendNode('url', project.getProperties().get('MavenURL'))

                        def scm = root.appendNode('scm')
                        scm.appendNode('url', project.getProperties().get('MavenSCMURL'))
                        scm.appendNode('connection', project.getProperties().get('MavenSCMConnection'))
                        scm.appendNode('developerConnection', project.getProperties().get('MavenSCMConnection'))

                        def license = root.appendNode('licenses').appendNode('license')
                        license.appendNode('name', project.getProperties().get('MavenLicenseName'))
                        license.appendNode('url', project.getProperties().get('MavenLicenseURL'))

                        def developer = root.appendNode('developers').appendNode('developer')
                        developer.appendNode('id', project.getProperties().get('MavenDeveloperID'))
                        developer.appendNode('name', project.getProperties().get('MavenDeveloperName'))
                        developer.appendNode('email', project.getProperties().get('MavenDeveloperEMail'))
                    }

                    groupId project.getProperties().get('Group')
                    artifactId project.getProperties().get('ArchivesBaseName')
                    version project.getProperties().get('Version')

                    from project.components.java

                    artifact('sourceJar') {
                        classifier "sources"
                    }

                    artifact('javadocJar') {
                        classifier 'javadoc'
                    }
                }
            }

            repositories {
                maven {
                    credentials {
                        username project.getProperties().get('ossrhUsername')
                        password project.getProperties().get('ossrhPassword')
                    }

                    if(project.version.endsWith('-SNAPSHOT')) {
                        url "https://oss.sonatype.org/content/repositories/snapshots/"
                    } else {
                        url "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
                    }
                }
            }
        }
    }
}