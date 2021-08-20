def projectName = 'fundpipe'
def version = "0.0.${currentBuild.number}"
def dockerImageTag = "${projectName}:${version}"

pipeline {
  agent any

  tools {
      maven 'maven 3.8.2'
//       jdk 'jdk8'
  }
  
  
  
  stages {
    
    stage ('Build') {
      steps {
          sh 'mvn -Dmaven.test.failure.ignore=true package' 
      }
//       post {
//           success {
//               junit 'target/surefire-reports/**/*.xml' 
//           }
//       }
  }
     stage('Build docker image') {
          // this stage also builds and tests the Java project using Maven
          steps {
            sh "docker build -t ${dockerImageTag} ."
            sh "docker run --name fundapp -p 8090:8080 --link mysql ${dockerImageTag}"
          }
      }
    stage('Deploy Container To Openshift') {
      steps {
        sh "oc login https://localhost:8443 --username admin --password admin --insecure-skip-tls-verify=true"
        sh "oc project ${projectName} || oc new-project ${projectName}"
        sh "oc delete all --selector app=${projectName} || echo 'Unable to delete all previous openshift resources'"
        sh "oc new-app ${dockerImageTag} -l version=${version}"
        sh "oc expose svc/${projectName}"
      }
    }
  }
}
