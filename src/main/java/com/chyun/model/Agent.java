package com.chyun.model;

import com.chyun.task.AgentTaskType;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Agent implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(Agent.class);
    private static boolean runProcessing = true;

    @Getter
    private AgentAuth agentAuth;

    private Agent(AgentAuth agentAuth) {
        this.agentAuth = agentAuth;
    }

    private void registerAgent() {
        List<AgentTaskType> agentTaskTypeList = new ArrayList<>();
        agentTaskTypeList.add(AgentTaskType.REGISTER_AGENT);
        agentTaskTypeList.add(AgentTaskType.INIT_AGENT);
        executeTask(agentTaskTypeList);
    }

    private void registerProduct() {
        List<AgentTaskType> agentTaskTypeList = new ArrayList<>();
        agentTaskTypeList.add(AgentTaskType.REGISTER_PRODUCT);
        executeTask(agentTaskTypeList);
    }

    public void statusAgent() {
        List<AgentTaskType> agentTaskTypeList = new ArrayList<>();
        agentTaskTypeList.add(AgentTaskType.STATUS_AGENT);
        executeTask(agentTaskTypeList);
    }

    public void LogAgent() {
        List<AgentTaskType> agentTaskTypeList = new ArrayList<>();
        agentTaskTypeList.add(AgentTaskType.LOG_AGENT);
        executeTask(agentTaskTypeList);
    }

    private void executeTask(List<AgentTaskType> agentTaskTypeList) {
        for (AgentTaskType agentTaskType : agentTaskTypeList) {
            agentTaskType.getAbstractTask().execute(this);
        }
        agentTaskTypeList.clear();
    }

    @Override
    public void run() {
        LOGGER.info("## Agent::BackGround Run : {}", Thread.currentThread().getId());
        while (runProcessing) {
            try {
                Thread.sleep(9000);
                statusAgent();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Agent agent = new Agent(new AgentAuth());
        agent.registerAgent();
        agent.registerProduct();
        Thread taskThread = new Thread(agent);
        taskThread.start();
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentAuth=" + agentAuth +
                '}';
    }
}
