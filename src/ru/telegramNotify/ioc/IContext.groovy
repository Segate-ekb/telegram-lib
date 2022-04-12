package ru.telegramNotify.ioc

import ru.telegramNotify.IStepExecutor

interface IContext {
    IStepExecutor getStepExecutor()
}