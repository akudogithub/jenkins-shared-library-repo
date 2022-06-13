def call(String repoUrl){
pipeline {
       agent any
        stages {
           stage("system-resource-check") {
               steps {
                   sh 'lscpu'
                   sh 'java -version'
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'main',
                          url: "${repoUrl}"
               }
           }
           stage("to-check-storage") {
               steps {
                   sh 'lsblk'
               }
           }
       }
}