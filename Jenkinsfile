pipeline {
    agent any

    stages {
        stage('Clone the Project') {
            steps {
                checkout scm
                echo "clone the project successfully."
            }
        }

        stage('Maven Clean Package') {
            steps {
                sh 'mvn clean package'
                echo "Package is successfully created."
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
                script {
                    withDockerRegistry(credentialsId: 'Docker_Credentials', url: 'https://index.docker.io/v1/') {
                      def app = docker.build("chetanpatel/studentapp:${env.BUILD_NUMBER}",'.').push()
                    } 
                }  
            }
        }
    }
}