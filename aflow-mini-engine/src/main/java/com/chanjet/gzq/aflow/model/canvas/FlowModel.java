package com.chanjet.gzq.aflow.model.canvas;

import com.chanjet.gzq.aflow.persistance.FlowDBHelper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by David on 2017/2/21.
 *
 * usage:
 *
 *  FlowModel model = JSONExtension.parseObject(json, FlowModel.class);
 *  model.setJson(json);
 *
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlowModel implements Serializable {

    private ArrayList<Figure> canvas;
    private FlowProperties userData;

    private String json;

    private String name;
    private String id;
    private String orgid;
    private String creator;
    private String createTime;

    public FlowModel() {
        this.id = UUID.randomUUID().toString();
    }

    public boolean save() {

        if(!FlowDBHelper.getInstance().saveFlow(json)) {
            return false;
        }
        return true;
    }

    public static String load(String orgId, String flowId) {
        return FlowDBHelper.getInstance().loadFlowDoc(flowId);
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String toJson() {
        return this.json;
    }

    public ArrayList<Figure> getCanvas() {
        return canvas;
    }

    public void setCanvas(ArrayList<Figure> canvas) {
        this.canvas = canvas;
    }

    public FlowProperties getUserData() {
        return userData;
    }

    public void setUserData(FlowProperties userData) {
        this.userData = userData;
    }


}
