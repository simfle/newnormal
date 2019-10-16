package com.chyun.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AgentResponseVO {

    @JsonProperty("auth")
    private AuthData auth = new AuthData();

    @JsonProperty("request")
    private ActionData request = new ActionData();
    @Data
    private class AuthData{
        private String siteHandShakeKey;
        private String nodeId;
    }

    @Data
    private class ActionData{
        private String action;
        private String revision;
        private List<String> params = new ArrayList<String>();
        private List<String> data = new ArrayList<String>();
    }
}
