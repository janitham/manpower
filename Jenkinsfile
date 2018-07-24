pipeline {
    agent any

    stages {
        stage('Build Image') {
            steps {
                script {
                    println("Building the docker image...")
                    if (isUnix()) {
                        sh "mvn clean install"
                    } else {
                        bat "mvn clean install"
                    }
                }
            }
        }
        stage('Deploy Image') {
            steps {
                script {
                    println("Deploying the docker image...")
                    if (isUnix()) {
                        sh "mvn deploy"
                    } else {
                        bat "mvn deploy"
                    }
                }
            }
        }
    }
}