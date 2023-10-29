pipeline {
    agent any

    stages {
        stage('Cloning Git') {
            steps {
                git([url: 'https://gitlab.com/Maria173/InterProg-PIbd21-Shestakova.git', branch: '6lab'])
             }
        }
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