#!/usr/bin/env groovy
package ru.telegramNotify

import groovy.json.*

class message {
    String text
    long chat_id
    String parse_mode = "MarkdownV2"
    Boolean disable_web_page_preview
    Boolean disable_notification
    int reply_to_message_id

    def serializeMessage(){
        def json = JsonOutput.toJson(this)
        json = json.getBytes("UTF-8")
        json = JsonOutput.prettyPrint(json)
        return json
    }
}
