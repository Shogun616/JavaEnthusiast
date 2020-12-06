pipeline {
   agent any

   stages {
      stage('Build') {
        steps {
          git 'https://github.com/Shogun616/JavaEnthusiast.git'
          echo 'Building...'
          echo "Running ${env.BUILD_ID} ${env.BUILD_DISPLAY_NAME} on ${env.NODE_NAME} and JOB ${env.JOB_NAME}"
        }
   }
   stage('Test') {
     steps {
        git 'https://github.com/Shogun616/JavaEnthusiast.git'
        echo 'Testing...'
     }
   }
   stage('Deploy') {
     steps {
          git 'https://github.com/Shogun616/JavaEnthusiast.git'
       echo 'Deploying...'
     }
   }
      stage('Package') {
     steps {
          git 'https://github.com/Shogun616/JavaEnthusiast.git'
       echo 'Packaging...'
     }
   }
  }
}