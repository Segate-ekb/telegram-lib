package ru.telegramNotify

import org.jenkinsci.plugins.pipeline.utility.steps.fs.FileWrapper
import org.jenkinsci.plugins.workflow.support.actions.EnvironmentAction

interface IStepExecutor {

    def withCredentials(List bindings, Closure body)

    EnvironmentAction env()

    def withEnv(List<String> strings, Closure body)

    def httpRequest(String httpMode, String url, String requestBody, String outputFile, String responseHandle, boolean wrapAsMultipart, String contentType, String validResponseCodes)
}