package ru.telegramNotify.ioc

class ContextRegistry implements Serializable {
    private static IContext context

    static void registerContext(IContext context) {
        ContextRegistry.context = context
    }

    static void registerDefaultContext(Object steps) {
        context = new DefaultContext(steps)
    }

    static IContext getContext() {
        return context
    }
}
