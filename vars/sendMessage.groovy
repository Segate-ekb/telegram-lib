#!/usr/bin/env groovy
import groovy.json.*
import ru.telegramNotify.ioc.ContextRegistry

def call(message, authToken = null) {
         ContextRegistry.registerDefaultContext(this)
         def telegram = new botManager()
          telegram.setAuthToken('1145915027:AAHEtQJGSTERyttKvXXQxd4Li1ax6aMNj-U')
          telegram.sendMessage(message)
    }