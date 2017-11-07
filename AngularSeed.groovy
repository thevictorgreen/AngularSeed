// Jenkins Job DSL to create Jobs

//Base Path For All Jobs Related to this project
def basePath = 'AngularProject';

//Folder already exists. Seed job inside of it
folder (basePath) {
  displayName('AngularProject');
  description('Folder for AngularProject');
}


//Git repository for this project
def repoUrl = "https://github.com/thevictorgreen/simpliqa4.git"; //Repository UrL

pipelineJob(basePath + "/SimpliQA4") { //JobName
  description("Angular 4 Webapp");
  definition {
    cpsScm {
      scriptPath("Jenkinsfile"); //Path to Build Script
      scm {
        git {
          remote {
            url(repoUrl); //Git Repository
            branch("master");
          }
        }
      }
      triggers {
        githubPush();
      }
    }
  }
}

//Git repository for this project
/*
def repoUrl = "https://github.com/thevictorgreen/nodemicro.git"; //Repository UrL

pipelineJob(basePath + "/NodeMicro") { //JobName
  description("NodeJS Micro Service");
  definition {
    cpsScm {
      scriptPath("JenkinsFile"); //Path to Build Script
      scm {
        git {
          remote {
            url(repoUrl); //Git Repository
            branch("master");
          }
        }
      }
    }
  }
}
*/
