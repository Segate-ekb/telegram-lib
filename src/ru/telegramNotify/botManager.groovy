#!/usr/bin/env groovy
package ru.telegramNotify
import groovy.json.*
import ru.telegramNotify.message
import ru.telegramNotify.IStepExecutor
import ru.telegramNotify.ioc.ContextRegistry
class botManager {
    private String authToken

    def sendMessage(message) {
        String urlString = "https://api.telegram.org/bot${this.authToken}/sendMessage"
        def requestBody = JsonOutput.toJson(message)
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()
        steps.httpRequest ('POST', urlString,,,,,requestBody,)
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
