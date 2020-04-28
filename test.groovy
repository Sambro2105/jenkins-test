pipeline {
    agent{node('master')}
    stages {
    stage ('Download from git'){
        checkout([$class: 'GitSCM',
                    branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [[$class: 'RelativeTargetDirectory',
                    relativeTargetDir: 'test']],
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: 'SergeyYakuninGit',url: 'https://github.com/Sambro2105/jenkins-test']]])
                
      }
        
       
    }
    
}
