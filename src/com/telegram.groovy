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
}
