#!/usr/bin/env groovy
import groovy.json.*
import ru.telegramNotify.ioc.ContextRegistry
import ru.telegramNotify.botManager
import ru.telegramNotify.message

def call(String text, def chat_id = Long.valueOf(env.TELEGRAM_CHAT), String parse_mode = "Markdown") {
       ContextRegistry.registerDefaultContext(this)
       chat_id =  Long.valueOf(chat_id); //Если передадут строку
      def message = new message(
            chat_id: chat_id,
            text: text,
            parse_mode:parse_mode)

      def telegram = new botManager()
      telegram.setAuthToken(env.TELEGRAM_TOKEN)
      requestBody = message.serializeMessage()
      echo requestBody
      telegram.sendMessage(requestBody)
    }