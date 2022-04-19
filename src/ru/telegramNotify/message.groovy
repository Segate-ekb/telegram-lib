#!/usr/bin/env groovy
package ru.telegramNotify

import groovy.json.*
import groovy.json.JsonGenerator
import groovy.json.JsonGenerator.Converter

class message {
    String text
    long chat_id
    String parse_mode = "MarkdownV2"
    Boolean disable_web_page_preview
    Boolean disable_notification
    int reply_to_message_id

    def serializeMessage(){
     def jsonGen = new JsonGenerator.Options()
        .disableUnicodeEscaping()  // Do not escape UNICODE.
        .build()
          return jsonGen.toJson(data)
     //return JsonOutput.prettyPrint(JsonOutput.toJson(this))
    }
}
