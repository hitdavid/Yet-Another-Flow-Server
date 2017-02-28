package com.chanjet.gzq.aflow.server;

/**
 * @author zhailz
 *
 * 时间：2017年2月26日 ### 下午2:28:56
 */
public enum FormActionEnum {
  
  /**
   * 同意操作 
   * */
  APPROVE(1),
  
  /**
   * 不同意操作
   * */
  DISAGREE(2), 
  
  /**
   * 指派操作
   * */
  ASSIGN(3);

  private int action;
  
  FormActionEnum(int action){
    this.setAction(action);
  }

  public int getAction() {
    return action;
  }

  public void setAction(int action) {
    this.action = action;
  }
}
