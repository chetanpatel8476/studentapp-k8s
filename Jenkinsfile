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

        stage('Build the Project') {
            steps {
                sh 'mvn -B -Dmaven.test.skip=true package'
                echo "Project is build successfully."
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
        
        stage('Deploy Student application in K8s Cluster') {
            steps{
                kubernetesDeploy configs: 'studentapp-deploy/studentapp/studentapp-deployment.yaml', 
                                 kubeConfig: [path: ''], 
                                 kubeconfigId: 'K8s_Config',
                                 enableConfigSubstitution: true
            }
        }
/**
        stage('Deploy Student application in K8s Cluster') {
            steps{
                withCredentials([kubeconfigFile(credentialsId: 'K8s_Config', variable: 'KUBECONFIG')]) {
                    sh 'kubectl apply -f studentapp-deploy/studentapp/studentapp-deployment.yaml'
                    sh 'kubectl apply -f studentapp-deploy/studentapp/studentapp-service.yaml'
                }
            }
        } **/
    }
}