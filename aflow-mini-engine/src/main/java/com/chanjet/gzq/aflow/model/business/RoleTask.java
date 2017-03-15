package com.chanjet.gzq.aflow.model.business;

import com.chanjet.gzq.aflow.server.WFContext;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by David on 2017/2/20.
 * 
 * 角色任务
 * 
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleTask extends Task implements Serializable {

    private String roleIds;

    public RoleTask() {

    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    /* (non-Javadoc)
     * @see com.chanjet.gzq.aflow.model.business.Task#behavior(com.chanjet.gzq.aflow.server.WFContext)
     */
    @Override
    public void behavior(WFContext context) {
      // TODO Auto-generated method stub
      
    }

    public String toXML() {
        return "<userTask id=\""+this.getId()+"\" name=\""+this.getUserData().getName()+"\" activiti:assignee=\"${userService.findManagerForEmployee("+this.getUserData().getUserIds()+")}\">\n"
            + "      <extensionElements>\n"
            + "        <activiti:taskListener event=\"create\" class=\"com.chanjet.gongzuoquan.workflow.activiticustom.TaskCustomService\"></activiti:taskListener>\n"
            + "      </extensionElements>\n"
            + "    </userTask>";
    }
}
