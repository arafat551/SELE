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

    post {
        always {
            emailext (
                subject: "Résultat de la compilation Jenkins",
                body: "La compilation est terminée. Voir le fichier joint pour plus d'infos.",
                to: "destinataire@example.com",
                attachLog: false,
                attachmentsPattern: 'index.html',
                mimeType: 'text/html',
                from: 'arafat551@gmail.com',
                replyTo: 'arafat551@gmail.com'
            )
        }
    }
}
