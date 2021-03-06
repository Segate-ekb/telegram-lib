package ru.telegramNotify

import org.jenkinsci.plugins.pipeline.utility.steps.fs.FileWrapper
import org.jenkinsci.plugins.workflow.support.actions.EnvironmentAction

class StepExecutor implements IStepExecutor {

    private steps

    StepExecutor(steps) {
        this.steps = steps
    }


    @Override
    def withCredentials(List bindings, Closure body) {
        steps.withCredentials(bindings) {
            body()
        }
    }

    @Override
    EnvironmentAction env() {
        return steps.env
    }


    @Override
    def withEnv(List<String> strings, Closure body) {
        steps.withEnv(strings) {
            body()
        }
    }

    @Override
    def httpRequest(String httpMode = 'POST', String url, String requestBody = "", String outputFile = "", String responseHandle = 'NONE', boolean wrapAsMultipart = false, String contentType = 'APPLICATION_JSON_UTF8', String validResponseCodes = '100:999') {
        steps.httpRequest responseHandle: responseHandle,
         outputFile: outputFile,
          url: url,
           wrapAsMultipart: wrapAsMultipart,
            httpMode: httpMode,
             contentType: contentType,
              requestBody: requestBody,
               validResponseCodes: validResponseCodes
    }
}
