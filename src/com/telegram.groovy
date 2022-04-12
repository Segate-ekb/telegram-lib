#!/usr/bin/env groovy
package com

class telegram {
    String authToken, chatId, parseMode = "MarkdownV2"
   
    def setAuthToken(String authToken) {
        if (authToken.trim().length() == 0) {
            throw new Exception("can't set auth token")
        }
        this.authToken = authToken
    }

    def setChatId(String chatId) {
        if (chatId.trim().length() == 0) {
            throw new Exception("can't set chatId")
        }
        this.chatId = chatId
    }

    def setParseMode(def parseMode){
        if (parseMode.trim().length() == 0) {
            throw new Exception("can't set parseMode")
        }
        this.parseMode = parseMode
    }

    def sendMessage(String message) {
        if (message.trim().length() == 0) {
            throw new Exception('Message is empty!')
        }
        String urlString = "https://api.telegram.org/bot${authToken}}/sendMessage"

        httpRequest httpMode: 'POST', requestBody: '''{"chat_id": 436258240,
        "parse_mode": "MarkdownV2",
        "text": "```
        Hello world!
        2 string#!@#$%^&```"}''',
         responseHandle: 'NONE',
          url: urlString, wrapAsMultipart: false
        echo response
    }

}
