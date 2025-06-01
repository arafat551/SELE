pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'rafk', url: 'https://github.com/arafat551/SELE.git'
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

    stage('Send Email') {
            steps {
                script {
                    emailext (
                        subject: '✔️ Rapport de test - Jenkins',
                        body: 'Bonjour,<br><br>Voici le rapport <b>index.html</b> généré par Jenkins.<br><br>Cordialement,<br>Jenkins',
                        to: 'kondiraf551@gmail.com',
                        from: 'kondiraf551@gmail.com',
                        attachmentsPattern: 'index.html'
                    )
                }
           }
}
