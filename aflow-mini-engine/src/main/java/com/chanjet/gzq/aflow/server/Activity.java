package com.chanjet.gzq.aflow.server;

/**
 * @author zhailz
 *
 * 时间：2017年2月26日 ### 下午3:48:58
 * 
 * NOTE:
 * 活动实例
 * 
 */
public class Activity {
  
  private String taskId;
  
  private String WorkFlowModelId;
  
  private String WorkFlowInstanceId;
  
  private String ownerUserId;
  
  private String fromId;
  
  private String activityId;
  
  private int activityState;
  
  private long owerUserId;
  
  private long createTime;
  
  private long updateTime;
  
  private long orgId;

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public String getWorkFlowModelId() {
    return WorkFlowModelId;
  }

  public void setWorkFlowModelId(String workFlowModelId) {
    WorkFlowModelId = workFlowModelId;
  }

  public String getWorkFlowInstanceId() {
    return WorkFlowInstanceId;
  }

  public void setWorkFlowInstanceId(String workFlowInstanceId) {
    WorkFlowInstanceId = workFlowInstanceId;
  }

  public String getOwnerUserId() {
    return ownerUserId;
  }

  public void setOwnerUserId(String ownerUserId) {
    this.ownerUserId = ownerUserId;
  }

  public String getFromId() {
    return fromId;
  }

  public void setFromId(String fromId) {
    this.fromId = fromId;
  }

  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }

  public int getActivityState() {
    return activityState;
  }

  public void setActivityState(int activityState) {
    this.activityState = activityState;
  }

  public long getOwerUserId() {
    return owerUserId;
  }

  public void setOwerUserId(long owerUserId) {
    this.owerUserId = owerUserId;
  }

  public long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(long createTime) {
    this.createTime = createTime;
  }

  public long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(long updateTime) {
    this.updateTime = updateTime;
  }

  public long getOrgId() {
    return orgId;
  }

  public void setOrgId(long orgId) {
    this.orgId = orgId;
  }
  

}
