pipeline {
    agent any
    
    tools {
        maven "M3"
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/keeley-bootcamp/jenkins-pipeline-challenge.git'
            }
        }
        stage('Compile') {
            steps {
                sh "mvn clean compile"  // Ensure code is compiled before analysis
            }
        }
        stage('Test') {
            steps {
                sh "mvn test"
            }
        }
        stage('Package') {
            steps {
                sh "mvn -Dmaven.test.skip -Dmaven.compile.skip package"
            }
        }
        stage('SonarQube Analysis') {
            environment {
                scannerHome = tool 'sonarqube'
            }
            steps {
                withSonarQubeEnv('sonar-qube-1') {        
                    sh "${scannerHome}/bin/sonar-scanner"
                }
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline:true
                }
            }
        }
    }
}

