package com.chyun.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentAuth {

    private String nodeId;
    private String sessionKey;
    private String machineUUID;

    @Override
    public String toString() {
        return "AgentAuth{" +
                "nodeId='" + nodeId + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", machineUUID='" + machineUUID + '\'' +
                '}';
    }
}
