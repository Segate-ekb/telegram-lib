#!/usr/bin/env groovy
import groovy.json.*

def call(message, authToken = null) {
        if (authToken == null) {
          authToken = env.TELEGRAM_TOKEN
        }

        String urlString = "https://api.telegram.org/bot${authToken}/sendMessage"
        def requestBody = JsonOutput.toJson(message)
        httpRequest httpMode: 'POST',
          contentType: 'APPLICATION_JSON',
          requestBody: requestBody,
          url: urlString,
          validResponseCodes: '100:999'
    }