BUILD_INFRASTRUCTURE = 'scm_terraform'
PROJECT_NAME = 'scm'
CJK_GIT_URL = 'https://github.com/nawinkumar94/Terraform-Aws-Two-Tier-Application.git'
BRANCH_NAME = 'master'
TERRAFORM_VERSION = '0.13.3'
REGION = 'ap-south-1'
BUCKET_NAME = 'terraform-state-nv-7777'
CREDENTIALS_ID = 'a0c3162c-f34d-4420-b302-a2bf1ffac98e'
OPERATION = 'OPERATION'
CHANNEL_NAME = '#devops'

pipelineJob(BUILD_INFRASTRUCTURE){
    displayName(PROJECT_NAME)
    description('Deploys the Terraform configurations')
    logRotator{
        daysToKeep(30)
        numToKeep(10)
    }
    parameters{
        stringParam('BRANCH_NAME', BRANCH_NAME, 'CJK Branch Details')
        stringParam('TERRAFORM_VERSION', TERRAFORM_VERSION, 'Version of Terraform to Deploy')
        stringParam('CJK_GIT_URL', CJK_GIT_URL, 'Terraform Project Infrastructure')
        choiceParam('OPERATION', ['apply', 'destroy'])
        stringParam('REGION', defaultValue = REGION)
        stringParam('BUCKET_NAME', BUCKET_NAME)
        credentialsParam('CREDENTIALS_ID'){
            defaultValue('CREDENTIALS_ID')
        }
    }
    definition{
        cpsScm{
            scm{
                git{
                    remote {
                        credentials(CREDENTIALS_ID)
                        url("https://github.com/nawinkumar94/Jenkins-Pipeline-Terraform.git")
                    }
                    branch('*/master')
                }
            scriptPath('Jenkins-Pipeline-Terraform/Jenkinsfile')
            lightweight()
            }
        }
    }
    properties{
        rebuild{
            autoRebuild(false)
            rebuildDisabled(false)
        }
    }

}
