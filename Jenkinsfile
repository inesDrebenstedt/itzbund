pipeline {
    agent any  // Or specify a specific agent

    stages {
      stage('Checkout') {
            steps {
                git 'https://github.com/inesDrebenstedt/itzbund.git' 
            }
        }
        stage('Build and Test') {
            agent any // optionally specify agent for this stage
            steps {
                withMaven(maven: 'Maven3.9.6') {
                    sh 'mvn clean install'  // Runs from the workspace root

                    // Option 1: Use the 'dir' parameter within the 'sh' step
                    //sh script: 'mvn clean install', dir: 'demo'

                    // Option 2:  Use 'cd'  (less recommended but works)
                    //sh "cd your_project_directory && mvn clean install"  // Be careful with this!  See explanations below.
                }
            }
        }

        stage('Code Quality') {
            agent any // optionally specify agent for this stage
            steps {
                withMaven(maven: 'Maven3.9.6') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }
}