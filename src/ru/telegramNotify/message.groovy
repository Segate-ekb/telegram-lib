#!/usr/bin/env groovy
package ru.telegramNotify

import groovy.json.*

class message {
    String text
    long chat_id
    String parse_mode = "Markdown"
    Boolean disable_web_page_preview
    Boolean disable_notification
    int reply_to_message_id

    def serializeMessage(){
return JsonOutput.prettyPrint(JsonOutput.toJson(this))
    }
}
