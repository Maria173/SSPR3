pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Шаг для сборки проекта Gradle
                sh './gradlew build'
            }
        }

        stage('Download Dependencies') {
            steps {
                // Шаг для скачивания и подключения зависимостей
                sh './gradlew downloadDependencies'
            }
        }

        stage('Test') {
            steps {
                // Шаг для запуска тестов
                sh './gradlew test'
            }
        }
    }
}