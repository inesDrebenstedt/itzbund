pipeline {
    agent any  // Or specify a specific agent
    environment {
        // Define a variable that will store the SonarQube token at runtime.
        // This is a placeholder; the actual value will be injected from credentials.
        SONAR_TOKEN = credentials('sqt1')
    }
    stages {
        stage('Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],  
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    userRemoteConfigs: [[url: 'https://github.com/inesDrebenstedt/itzbund.git']], 
                ])
            }
        }
        stage('Build and Test') {
            agent any // optionally specify agent for this stage
            steps {
                    //bat 'mvn clean install'   Runs from the workspace root
                   bat 'mvn clean install'
            }
        }

        stage('Code Quality') {
            agent any // optionally specify agent for this stage
            steps {
                    bat 'mvn sonar:sonar sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=%SONAR_TOKEN%'
            }
        }
    }
}