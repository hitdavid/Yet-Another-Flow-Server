package com.chanjet.gzq.aflow.model.business;

import com.chanjet.gzq.aflow.engine.ElementBehavior;
import com.chanjet.gzq.aflow.model.canvas.Port;
import com.chanjet.gzq.aflow.model.canvas.UserProperties;
import com.chanjet.gzq.aflow.server.WFContext;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by David on 2017/2/22.
 * 
 * NOTE:
 * 每一个实现task的节点或者说图形，必须有的行为
 * 1. 此节点的动作（什么都不执行，直接到下一个task，也算一个动作）
 * 2. 此节点的入口
 * 3. 此节点的出口
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Task implements ElementBehavior {

    private static final long serialVersionUID = 1L;

    @JsonProperty("ports")
    private ArrayList<Port> ports;
    private UserProperties userData;

    private HashMap<String, Connection> outputConnections;
    private HashMap<String, Connection> inputConnections;

    private String id;

    public Task() {
        outputConnections = new HashMap<String, Connection>();
        inputConnections = new HashMap<String, Connection>();
    }

    public void addOutputConnection(Connection c) {
        outputConnections.put(c.getId(), c);
    }

    public void addInputConnection(Connection c) {
        inputConnections.put(c.getId(), c);
    }

    public abstract void behavior(WFContext context);

    public List<Task> next() {
        ArrayList<Task> next = new ArrayList<Task>();
        for(Connection c : outputConnections.values()) {
            next.add((Task)c.getTargetTask());
        }

        return next;
    }

    public List<Task> previous() {

        ArrayList<Task> prev = new ArrayList<Task>();
        for(Connection c : inputConnections.values()) {
            prev.add((Task)c.getSourceTask());
        }

        return prev;
    }

    public HashMap<String, Connection> getOutputConnections() {
        return outputConnections;
    }

    public void setOutputConnections(HashMap<String, Connection> outputConnections) {
        this.outputConnections = outputConnections;
    }

    public HashMap<String, Connection> getInputConnections() {
        return inputConnections;
    }

    public void setInputConnections(HashMap<String, Connection> inputConnections) {
        this.inputConnections = inputConnections;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Port> getPorts() {
        return ports;
    }

    public void setPorts(ArrayList<Port> ports) {
        this.ports = ports;
    }

    public UserProperties getUserData() {
        return userData;
    }

    public void setUserData(UserProperties userData) {
        this.userData = userData;
    }
}
