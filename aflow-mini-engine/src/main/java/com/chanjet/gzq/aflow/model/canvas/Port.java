package com.chanjet.gzq.aflow.model.canvas;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by David on 2017/2/21.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Port implements Serializable {

    private String name;
    private String port;
    private String locator;

    private ArrayList<String> connectionId;

    public Port() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public ArrayList<String> getConnectionId() {
        return connectionId;
    }

    public void addConnectionId(String connectionId) {
        if(this.connectionId == null) {
            this.connectionId = new ArrayList<String>();
        }
        this.connectionId.add(connectionId);
    }
}
