def call(String repoUrl){
  pipeline{
  agent any 
  stages{
    stage('version-control'){
      steps{
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/techopsteam4/project-9-pipeline.git']]])
      }
    }
    stage('parallel-job1'){
      parallel{
        stage('sub-job1'){
          steps{
            echo 'action1'
          }
        }
        stage('sub-job2'){
          steps{
            echo 'action2'
          }
        }
      }
    }
    stage('code-build'){
      steps{
        sh 'cat /etc/passwd'
      }
    }
    stage('parallel-job'){
      parallel{
        stage('sub-job3'){
          steps{
            echo 'action 3'
            sh 'ps -ef'
          }
        }
        stage('sub-job4'){
          steps{
            echo 'action 4'
            sh 'cal 2025'
          }
        }
      }
    }
    stage('code-deploy'){
      steps{
        sh 'tail -5 /etc/passwd'
        sh 'head -3 /etc/passwd'
      }
    }
  }
}
 }