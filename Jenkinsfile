pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/arafat551/SELE.git'
            }
        }

        stage('Compile and Execute') {
            steps {
                dir('src/main/java') {
                    bat 'javac NEW/Testing/App.java'
                    bat 'java NEW.Testing.App'
                }
            }
        }

        stage('Generate File') {
            steps {
                bat 'echo "mise à jour" > index.html'
            }
        }

        stage('Git Commit') {
            steps {
                bat 'git config user.email "you@example.com"'
                bat 'git config user.name "Your Name"'
                bat 'git add .'
                bat 'git commit -m "je suis la mise" || echo "rien à commit"'
            }
        }
    }
}
