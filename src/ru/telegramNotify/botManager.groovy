#!/usr/bin/env groovy
package ru.telegramNotify

import ru.telegramNotify.message
import ru.telegramNotify.IStepExecutor
import ru.telegramNotify.ioc.ContextRegistry

class botManager {
    private String authToken

    def sendMessage(requestBody) {
        String urlString = getUrl()
        println requestBody
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()
        steps.httpRequest ('POST', urlString,requestBody)
    }

    def setAuthToken (String authToken = ""){
        if (authToken.trim().length() == 0){
            throw new Exception("Auth token is empty!")
        }
        else{
            this.authToken = authToken
        }
    }

    String getUrl(){
        if (this.authToken.trim().length() == 0){
             throw new Exception("Auth token is empty!") 
        }
        return "https://api.telegram.org/bot${this.authToken}/sendMessage" 
    }
}
