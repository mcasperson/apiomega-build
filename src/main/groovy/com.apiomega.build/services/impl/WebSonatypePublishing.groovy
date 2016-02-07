package com.apiomega.build.services.impl

import com.apiomega.build.services.SonatypePublishing
import org.gradle.api.Project
import org.gradle.api.artifacts.maven.MavenDeployment

/**
 * An implementation that is shared across APIOmega projects to provide a way to publish to Sonatype
 */
trait WebSonatypePublishing implements SonatypePublishing {
    void configureSonatypePublishing(Project project) {
        assert project != null;

        project.task('javadocJar', 'Jar') {
            classifier = 'javadoc'
            from javadoc
        }

        project.task('sourcesJar', 'Jar') {
            classifier = 'sources'
            from sourceSets.main.allSource
        }

        project.artifacts {
            archives javadocJar, sourcesJar
        }

        project.signing {
            sign configurations.archives
        }

        project.uploadArchives {
            repositories {
                mavenDeployer {
                    beforeDeployment { MavenDeployment deployment -> signing.signPom(deployment) }

                    repository(url: "https://oss.sonatype.org/service/local/staging/deploy/maven2/") {
                        authentication(
                                userName: project.getProperties().get('ossrhUsername'),
                                password: project.getProperties().get('ossrhPassword'))
                    }

                    snapshotRepository(url: "https://oss.sonatype.org/content/repositories/snapshots/") {
                        authentication(
                                userName: project.getProperties().get('ossrhUsername'),
                                password: project.getProperties().get('ossrhPassword'))
                    }

                    pom.project {
                        name project.getProperties().get('MavenName')
                        packaging 'war'
                        // optionally artifactId can be defined here
                        description project.getProperties().get('MavenDescription')
                        url project.getProperties().get('MavenURL')

                        scm {
                            connection project.getProperties().get('MavenSCMConnection')
                            developerConnection project.getProperties().get('MavenSCMConnection')
                            url project.getProperties().get('MavenSCMURL')
                        }

                        licenses {
                            license {
                                name project.getProperties().get('MavenLicenseName')
                                url project.getProperties().get('MavenLicenseURL')
                            }
                        }

                        developers {
                            developer {
                                id project.getProperties().get('MavenDeveloperID')
                                name project.getProperties().get('MavenDeveloperName')
                                email project.getProperties().get('MavenDeveloperEMail')
                            }
                        }
                    }
                }
            }
        }
    }
}