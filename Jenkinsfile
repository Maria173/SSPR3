pipeline {
    agent any

    stages {
        stage('Cloning Git') {
            steps {
                git([url: 'https://github.com/Maria173/SSPR3.git', branch: '6lab'])
            }
        }
        stage('Build') {
			steps {
				bat 'docker build -t mshe73/lab:latest .'
			}
		}
        stage('Test') {
            steps {
				bat 'FOR /F "tokens=*" %%i IN (\'docker ps -a -q\') DO docker stop %%i'
				bat 'docker rm "test_sspr"'
				bat 'docker run -d --name "test_sspr" mshe73/lab:latest bash'
				bat 'docker exec "test_sspr" sh -c "./gradlew test"'
				bat 'docker stop "test_sspr"'
            }
        }

        stage("Push Image To Docker Hub") {
            steps {
                bat "docker login --username mshe73 --password ${ponchik73}"
                bat 'docker push mshe73/lab:latest'
            }
        }
    }
    post {
		always {
			script {
				node {
					bat 'docker logout'
				}
            }
		}
	}
}