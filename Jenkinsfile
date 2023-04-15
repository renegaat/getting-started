pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the source code from GitHub...'
                git 'https://github.com/renegaat/getting-started.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building the Quarkus application...'
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                echo 'Running unit tests...'
                sh 'mvn test'
            }
        }
        stage('package') {
                    steps {
                        echo 'package app...'
                        sh 'mvn package -Pnative -Dquarkus.native.container-build=true'
                    }
                }
    }
}