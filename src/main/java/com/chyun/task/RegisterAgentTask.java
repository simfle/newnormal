package com.chyun.task;

import com.chyun.model.Agent;
import com.chyun.model.AgentAuth;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class RegisterAgentTask extends AbstractTask{

    private static final Logger LOGGER = LogManager.getLogger(RegisterAgentTask.class);

    //여기서 nodeId 주입
    @Override
    public void execute(Agent agent) {
        System.out.println("RegisterAgentTask::execute");
        AgentAuth agentAuth = agent.getAgentAuth();
        agentAuth.setNodeId("register_nodeId");
        agentAuth.setMachineUUID(UUID.randomUUID().toString());
        agentAuth.setSessionKey("register_sessionKey");

    }
}
