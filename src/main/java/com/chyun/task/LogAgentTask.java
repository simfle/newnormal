package com.chyun.task;

import com.chyun.model.Agent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogAgentTask extends AbstractTask {

    private static final Logger LOGGER = LogManager.getLogger(LogAgentTask.class);

    @Override
    public void execute(Agent agent) {
        System.out.println("LogAgentTask::execute");
    }
}
