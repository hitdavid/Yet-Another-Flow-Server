package com.chanjet.gzq.aflow.model.business;

import com.chanjet.gzq.aflow.server.WFContext;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by David on 2017/2/20.
 * 
 * 人员节点
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTask extends Task implements Serializable {

    private String userIds;

    public UserTask() {

    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    /* (non-Javadoc)
     * @see com.chanjet.gzq.aflow.model.business.Task#behavior(com.chanjet.gzq.aflow.server.WFContext)
     */
    @Override
    public void behavior(WFContext context) {
      //前面执行完成
      
      //
      
    }

    public String toXML() {
        return "<userTask id=\""+this.getId()+"\" name=\""+this.getUserData().getName()+"\" activiti:assignee=\""+this.getUserData().getUserIds()+"\">\n"
            + "      <extensionElements>\n"
            + "        <activiti:taskListener event=\"create\" class=\"com.chanjet.gongzuoquan.workflow.activiticustom.TaskCustomService\"></activiti:taskListener>\n"
            + "      </extensionElements>\n"
            + "    </userTask>";
    }
}
