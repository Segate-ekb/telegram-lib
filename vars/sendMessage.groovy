#!/usr/bin/env groovy
def call(message, authToken = null) {
        if (authToken == null) {
          authToken = env.TELEGRAM_TOKEN
        }

        String urlString = "https://api.telegram.org/bot${authToken}/sendMessage"

        def response = httpRequest 
                        httpMode: 'POST',
                        contentType: 'APPLICATION_JSON',
                        requestBody: JsonOutput.toJson(message),
                        url: urlString,
                        validResponseCodes: '100:999'
        println('Status: '+response.status)
        println('Response: '+response.content)
    }