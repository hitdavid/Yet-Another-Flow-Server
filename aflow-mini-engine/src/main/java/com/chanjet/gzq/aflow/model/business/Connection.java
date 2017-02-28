package com.chanjet.gzq.aflow.model.business;

import com.chanjet.gzq.aflow.model.canvas.ConnectionPoint;
import com.chanjet.gzq.aflow.model.canvas.UserProperties;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by David on 2017/2/20.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Connection implements Serializable {

    private String id;
    private ConnectionPoint source;
    private ConnectionPoint target;

    private Task sourceTask;
    private Task targetTask;

    private UserProperties userData;

    public Connection() {
        userData = new UserProperties();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ConnectionPoint getSource() {
        return source;
    }

    public void setSource(ConnectionPoint source) {
        this.source = source;
    }

    public ConnectionPoint getTarget() {
        return target;
    }

    public void setTarget(ConnectionPoint target) {
        this.target = target;
    }

    public UserProperties getUserData() {
        return userData;
    }

    public void setUserData(UserProperties userData) {
        this.userData = userData;
    }

    public Task getSourceTask() {
        return sourceTask;
    }

    public void setSourceTask(Task sourceTask) {
        this.sourceTask = sourceTask;
    }

    public Task getTargetTask() {
        return targetTask;
    }

    public void setTargetTask(Task targetTask) {
        this.targetTask = targetTask;
    }
}
