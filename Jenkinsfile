pipeline {
    agent any
    stages {
        stage("clone") {
            steps {
                git branch: 'main', url: 'https://github.com/arafat551/SELE.git'
            }
        }
        stage("compiler et execter") {
            steps {
                dir("src/main/java") {
                    bat "javac NEW/Testing/App.java"
                    bat "java NEW.Testing.App"
                }
            }
            stage ("faire un push"){
                steps{
                dir("."){
                    bat "echo > index.html"
                    bat "git add ."
                    bat "git commit -m je suis la mise"
                    bat "git push -f origin main"
                }
                }
            }
        }
    }
}
