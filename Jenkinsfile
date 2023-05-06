pipeline {
    agent any

    environment {
            GRAALVM_HOME = "/usr/lib/jvm/graalvm-ce-java11-22.1.0"
        }
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
        stage('Build Quarkus Native Image') {
                    steps {
                        echo 'Building Quarkus Native image...'
                        script {
                            sh "mvn clean package -Pnative"
                        }
                    }
        }
        stage('Test') {
            steps {
                echo 'Running unit tests...'
                sh 'mvn test'
            }
        }
    }
}
