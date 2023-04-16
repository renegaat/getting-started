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
         stage('Build and push Docker Image') {
                    steps {
                        echo 'Building the Docker image...'
                        script {
                            sh "docker build -f src/main/docker/Dockerfile.jvm -t getting-started-jvm:latest ."
                            sh "docker push renegaat/getting-started-jvm:latest"
                        }
                    }
            }
    }
}
