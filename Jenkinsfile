pipeline {
    agent any

    tools {
        jdk 'JDK 21'
        maven 'Maven 3.9'
    }

    stages {
        stage('Run tests') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn -B clean test'
                    } else {
                        bat 'mvn -B clean test'
                    }
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
