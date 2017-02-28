package com.chanjet.gzq.aflow.form;

import java.util.Map;

/**
 * @author zhailz
 *
 * 时间：2017年2月26日 ### 上午10:56:16
 * 
 * Note: 单据的基础 简单的表示
 */
public class Form {
  
  private String formId;
  private String formType;
  private String formBussinessKey;
  private Map<String,String> formKeyValue;
  public String getFormId() {
    return formId;
  }
  public void setFormId(String formId) {
    this.formId = formId;
  }
  public String getFormType() {
    return formType;
  }
  public void setFormType(String formType) {
    this.formType = formType;
  }
  public String getFormBussinessKey() {
    return formBussinessKey;
  }
  public void setFormBussinessKey(String formBussinessKey) {
    this.formBussinessKey = formBussinessKey;
  }
  public Map<String, String> getFormKeyValue() {
    return formKeyValue;
  }
  public void setFormKeyValue(Map<String, String> formKeyValue) {
    this.formKeyValue = formKeyValue;
  }
  
  
  
}
