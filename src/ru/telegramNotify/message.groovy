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
      def generator = new groovy.json.JsonGenerator.Options()
                         .excludeNulls()
                         .dateFormat('yyyy')
                         .excludeFieldsByName('bar', 'baz')
                         .excludeFieldsByType(java.sql.Date)
                         .build()
     return JsonOutput.prettyPrint(JsonOutput.toJson(this))
    }
}
