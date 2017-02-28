package com.chanjet.gzq.aflow.model.business;

import com.chanjet.gzq.aflow.server.WFContext;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by David on 2017/2/20.
 * 
 * 条件分支
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BranchTask extends Task implements Serializable {

    private String templateId;
    private String templateName;
    private String fieldId;
    private String fieldName;

    public BranchTask() {

    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /* (non-Javadoc)
     * @see com.chanjet.gzq.aflow.model.business.Task#behavior(com.chanjet.gzq.aflow.server.WFContext)
     */
    @Override
    public void behavior(WFContext context) {
      // TODO Auto-generated method stub
      
    }

}
