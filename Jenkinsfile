pipeline {
    agent any

    stages {
        stage('Prepare') {
            steps {
                script {
                    releasedVersion = getReleasedVersion()
                    println(releasedVersion)
                }
            }
        }

        stage('Build') {
            steps {
                withMaven(maven: 'maven3.0.4') {
                    script {
                        println("Building the docker image & Artifact...")
                        if (isUnix()) {
                            sh "mvn clean install"
                        } else {
                            bat "mvn clean install"
                        }
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    println("Building the docker image & Deploy Snapshots...")
                    if (isUnix()) {
                        sh "export releaseVersion=" + releasedVersion + "-SNAPSHOT && " + "docker-compose up -d"
                    } else {
                        bat "set releaseVersion=" + releasedVersion + "-SNAPSHOT && " + "docker-compose up -d"
                    }
                    println("")
                }
            }
        }

        stage('Tests') {
            steps {
                script {
                    withMaven(maven: 'maven3.0.4') {
                        println("Deploying the docker image...")
                        if (isUnix()) {
                            /*sh 'mvn clean test -Dmaven.test.failure.ignore=true'
                            junit testResults: 'tests/bobcat/target/*.xml', allowEmptyResults: true
                            archiveArtifacts 'tests/bobcat/target/**'
                            junit testResults: 'tests/rest-assured/build/*.xml', allowEmptyResults: true
                            archiveArtifacts 'tests/rest-assured/build/**'
                            dockerCmd 'rm -f snapshot'*/

                            sh "export releaseVersion=" + releasedVersion + "-SNAPSHOT && " + "docker-compose down"
                        } else {
                            bat "set releaseVersion=" + releasedVersion + "-SNAPSHOT && " + "docker-compose down"
                        }
                    }
                }
            }
        }

        stage('Release') {
            steps {
                script {
                    withMaven(maven: 'maven3.0.4') {
                        println("Releasing :" + releasedVersion)
                    }
                    /*withCredentials([usernamePassword(credentialsId: 'github', passwordVariable: 'password', usernameVariable: 'username')]) {
                        if (isUnix()) {
                            sh "mvn release:prepare release:perform -Dusername=${username} -Dpassword=${password}"
                        } else {
                            bat "mvn release:prepare release:perform -Dusername=${username} -Dpassword=${password}"
                        }
                    }
                    if (isUnix()) {
                        sh "mvn clean deploy -Dproject.version=" + releasedVersion
                    } else {
                        bat "mvn clean deploy -Dproject.version=" + releasedVersion
                    }*/
                }
            }
        }

        stage('Deploy @ Prod') {
            steps {
                script {
                    println("Deploying the docker image...")
                    if (isUnix()) {
                        sh "export releaseVersion=" + releasedVersion + " && " + "docker-compose up -d"
                    } else {
                        bat "set releaseVersion=" + releasedVersion + " && " + "docker-compose up -d"
                    }
                }
            }
        }
    }
}

def releasedVersion

def getReleasedVersion() {
    return (readFile('pom.xml') =~ '<version>(.+)-SNAPSHOT</version>')[0][1]
}