package com.chanjet.gzq.aflow.model.business;

import com.chanjet.gzq.aflow.engine.ElementBehavior;
import com.chanjet.gzq.aflow.model.canvas.FlowProperties;
import com.chanjet.gzq.aflow.model.deserailizer.FlowDeserializer;
import com.chanjet.gzq.aflow.util.JSONExtension;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by David on 2017/2/21.
 *
 *
 * FlowDefinition newFLow = FlowDefinition.create(json);
 * boolean canSave = newFLow.isValid();
 *
 *
 *
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = FlowDeserializer.class)
public class FlowDefinition implements Serializable {

    private Start start;
    private End end;
    private HashMap<String, Task> taskTable;
    private HashMap<String, Connection> connectionTable;

    FlowProperties userData;

    public FlowDefinition() {
        userData = new FlowProperties();
        taskTable = new HashMap<String, Task>();
    }

    public static FlowDefinition create(String json) {

        FlowDefinition flowDefinition = JSONExtension.parseObject(json, FlowDefinition.class);
        flowDefinition.init();
        return flowDefinition;
    }

    public void init() {

        for (Task t : taskTable.values()) {
            if (t instanceof Start) {
                this.start = (Start) t;
            }
            else if (t instanceof End) {
                this.end = (End) t;
            }
        }
    }

    public boolean isValid() {
        if(! checkEmptyPortNotExist()) {
            return false;
        }

        if(! checkNotStartDirectToEnd()) {
            return false;
        }

        return true;
    }

    private boolean checkEmptyPortNotExist() {
        for (Task t : taskTable.values()) {
            if(t.getOutputConnections().size() < t.getPorts().size() - 1 ) {
                return false;
            }
        }
        return true;
    }

    private boolean checkNotStartDirectToEnd() {
        for(Connection c : this.start.getOutputConnections().values()) {
            if(c.getTargetTask().getId().equals(this.end.getId())) {
                return false;
            }
        }

        return true;
    }

    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }

    public End getEnd() {
        return end;
    }

    public void setEnd(End end) {
        this.end = end;
    }

    public String getName() {
        return userData.getName();
    }

    public String getId() {
        return userData.getId();
    }

    public String getType() {
        return userData.getType();
    }

    public String getFormTemplateId() {
        return userData.getFormTemplateId();
    }

    public String getFormTemplateName() {
        return userData.getFormTemplateName();
    }

    public FlowProperties getUserData() {
        return userData;
    }

    public void setUserData(FlowProperties userData) {
        this.userData = userData;
    }

    public HashMap<String, Task> getTaskTable() {
        return taskTable;
    }

    public void setTaskTable(HashMap<String, Task> taskTable) {
        this.taskTable = taskTable;
    }

    public HashMap<String, Connection> getConnectionTable() {
        return connectionTable;
    }

    public void setConnectionTable(HashMap<String, Connection> connectionTable) {
        this.connectionTable = connectionTable;
    }

    /**
     * @param taskId
     * 
     * 根据Id返回需要的元素
     */
    public ElementBehavior getTaskById(String taskId) {
      // TODO Auto-generated method stub
      return null;
    }

    public String toXML() {

        StringBuilder sb = new StringBuilder();

        sb.append("<process id=\""+this.getId()+"\" name=\""+this.getUserData().getName()+"\" isExecutable=\"true\">"+"\n");

        for(Task t : taskTable.values()) {
            sb.append(t.toXML()+"\n");
        }

        for(Connection t : connectionTable.values()) {
            sb.append(t.toXML()+"\n");
        }

        sb.append("</process>"+"\n");

        return sb.toString();
    }


}
