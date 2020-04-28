pipeline{
    agent{node('master')
    }
    
    stages{
        stage('create test.txt'){
            steps{
                script{
                    sh "touch test.txt";
                }
            }
            
        }
        stage('hard disk test'){
            steps{
                script{
                    sh "df -h > test.txt";
                }
            }
        }
        
        stage('cpu test'){
            steps{
                script{
                    def output =sh(script: "free -m | head -n 2", returnStdout: true).toString().trim()
                    if (output.indexOf('5') == -1){
                        sh "echo ${output} >> test.txt"
                    }  else {
                    currentBuild.result = 'FAILURE'
                    }
                    // sh "free -m | head -n 2 >> test.txt"
                }
            }
        }
    }
}
