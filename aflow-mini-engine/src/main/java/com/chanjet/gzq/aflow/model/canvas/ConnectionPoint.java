package com.chanjet.gzq.aflow.model.canvas;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by David on 2017/2/22.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConnectionPoint implements Serializable {

    private String node;
    private String port;

//    private Task targetTask;

    public ConnectionPoint() {

    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

//    public Task getTargetTask() {
//        return targetTask;
//    }
//
//    public void setTargetTask(Task targetTask) {
//        this.targetTask = targetTask;
//    }
}
