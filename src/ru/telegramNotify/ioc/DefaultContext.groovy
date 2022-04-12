package ru.telegramNotify.ioc

import ru.telegramNotify.IStepExecutor
import ru.telegramNotify.StepExecutor

class DefaultContext implements IContext, Serializable {
    private steps

    DefaultContext(steps) {
        this.steps = steps
    }

    @Override
    IStepExecutor getStepExecutor() {
        return new StepExecutor(this.steps)
    }
}
