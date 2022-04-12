#!/usr/bin/env groovy
import groovy.json.*
import ru.telegramNotify.ioc.ContextRegistry
import ru.telegramNotify.botManager

def call(message) {
         ContextRegistry.registerDefaultContext(this)
         def telegram = new botManager()
          telegram.setAuthToken(env.TELEGRAM_TOKEN)
          telegram.sendMessage(message)
    }