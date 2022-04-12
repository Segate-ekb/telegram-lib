#!/usr/bin/env groovy
package ru.telegramNotify
import groovy.json.*
import ru.telegramNotify.message

class botManager {
    private String authToken

    def sendMessage(message) {
        String urlString = "https://api.telegram.org/bot${this.authToken}/sendMessage"
        def requestBody = JsonOutput.toJson(message)
        httpRequest httpMode: 'POST',
          contentType: 'APPLICATION_JSON',
          requestBody: requestBody,
          url: urlString,
          validResponseCodes: '100:999'
    }
    def setAuthToken (string authToken = ""){
        if (authToken.trim().length() == 0){
            this.authToken = env.TELEGRAM_TOKEN
        }
        else{
            this.authToken = authToken
        }
    }
}
