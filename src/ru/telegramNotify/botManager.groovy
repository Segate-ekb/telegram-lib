#!/usr/bin/env groovy
package ru.telegramNotify
import groovy.json.*
import ru.telegramNotify.message
import ru.telegramNotify.IStepExecutor

class botManager {
    private String authToken

    def sendMessage(message) {
        String urlString = "https://api.telegram.org/bot${this.authToken}/sendMessage"
        def requestBody = JsonOutput.toJson(message)
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()
        steps.httpRequest (httpMode: 'POST',
          contentType: 'APPLICATION_JSON',
          requestBody: requestBody,
          url: urlString,
          validResponseCodes: '100:999')
    }
    def setAuthToken (String authToken = ""){
        if (authToken.trim().length() == 0){
         //   this.authToken = script.env.TELEGRAM_TOKEN
        }
        else{
            this.authToken = authToken
        }
    }
}
