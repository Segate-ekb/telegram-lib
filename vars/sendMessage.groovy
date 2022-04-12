#!/usr/bin/env groovy
import groovy.json.*
import ru.telegramNotify.ioc.ContextRegistry
import ru.telegramNotify.botManager
import ru.telegramNotify.message

def call(String text, int chat_id = "", String parse_mode = "") {
       ContextRegistry.registerDefaultContext(this)

      if (chat_id.trim().length() == 0){
            chat_id = env.TELEGRAM_CHAT
      }
      if (parse_mode.trim().length() == 0){
            parse_mode = "MarkdownV2"
      }
      
      def message = new message(
            chat_id: chat_id,
            text: text,
            parse_mode:parse_mode)

      def telegram = new botManager()
      telegram.setAuthToken(env.TELEGRAM_TOKEN)
      telegram.sendMessage(message.serializeMessage())
    }