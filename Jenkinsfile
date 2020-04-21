pipeline {
    agent any

    stages {
        stage('Clone the Project') {
            steps {
                checkout scm
                echo "clone the project successfully."
            }
        }

        stage('Execute Unit Tests and Generate Code Coverage Report') {
            steps {
                sh 'mvn -B clean test jacoco:report'
                echo "Performed unit tests successfully."   
            }
        }

        stage('Build & Push the Docker image') {
            steps {
                docker.withDockerRegistry(credentialsId: 'Docker_Credentials', toolName: 'Docker', url: 'https://hub.docker.com/') {
                    def app = docker.build("chetanpatel/studentapp:${env.BUILD_NUMBER}",'.').push()
                }   
            }
        }
    }
}