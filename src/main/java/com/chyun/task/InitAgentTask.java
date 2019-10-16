package com.chyun.task;

import com.chyun.model.Agent;
import com.chyun.model.AgentAuth;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class InitAgentTask extends AbstractTask{

    private static final Logger LOGGER = LogManager.getLogger(InitAgentTask.class);

    @Override
    public void execute(Agent agent) {
        System.out.println("InitAgentTask::execute");

        LOGGER.info("## RegisterAgentTask::Agent : {}", agent);

        AgentAuth agentAuth = agent.getAgentAuth();
        agentAuth.setNodeId("init_nodeId");
        agentAuth.setMachineUUID(UUID.randomUUID().toString());
        agentAuth.setSessionKey("init_sessionKey");

        LOGGER.info("## InitAgentTask::Agent : {}", agent);

    }
}
