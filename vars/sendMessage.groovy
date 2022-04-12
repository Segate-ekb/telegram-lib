#!/usr/bin/env groovy
import groovy.json.*
import ru.telegramNotify.ioc.ContextRegistry
import ru.telegramNotify.botManager
import ru.telegramNotify.message

def call(String text, int chat_id = env.TELEGRAM_CHAT.toInteger(), String parse_mode = "MarkdownV2") {
       ContextRegistry.registerDefaultContext(this)
      def message = new message(
            chat_id: chat_id,
            text: text,
            parse_mode:parse_mode)

      def telegram = new botManager()
      telegram.setAuthToken(env.TELEGRAM_TOKEN)
      telegram.sendMessage(message.serializeMessage())
    }