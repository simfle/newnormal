package com.chyun.task;

public enum AgentTaskType {

    REGISTER_AGENT(new RegisterAgentTask()),
    INIT_AGENT(new InitAgentTask()),
    REGISTER_PRODUCT(new RegisterProductTask()),
    STATUS_AGENT(new StatusAgentTask()),
    LOG_AGENT(new LogAgentTask());

    private final AbstractTask abstractTask;

    AgentTaskType(AbstractTask abstractTask) {
        this.abstractTask = abstractTask;
    }

    public AbstractTask getAbstractTask() {
        return abstractTask;
    }
}
