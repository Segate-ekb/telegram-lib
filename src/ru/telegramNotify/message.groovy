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
        return StringEscapeUtils.unescapeJavaScript(
            JsonOutput.prettyPrint(JsonOutput.toJson(this))
        )

    }
}
