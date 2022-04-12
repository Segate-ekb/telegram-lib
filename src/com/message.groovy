#!/usr/bin/env groovy
package com

class message {
    int chat_id
    String parse_mode = "MarkdownV2"
    String text
    Boolean disable_web_page_preview
    Boolean disable_notification
    int reply_to_message_id
}
