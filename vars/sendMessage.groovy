#!/usr/bin/env groovy

def call(String message) {
        if (message.trim().length() == 0) {
            throw new Exception('Message is empty!')
        }
        String authToken = '1145915027:AAHEtQJGSTERyttKvXXQxd4Li1ax6aMNj-U'
        String urlString = "https://api.telegram.org/bot${authToken}/sendMessage"

        httpRequest httpMode: 'POST', requestBody: '''{"chat_id": 436258240,
        "parse_mode": "MarkdownV2",
        "text": "```
        Hello world!
        2 string#!@#$%^&```"}''',
          url: urlString, 
          validResponseCodes: '100:999'
        echo response
    }