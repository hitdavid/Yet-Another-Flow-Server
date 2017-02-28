package com.chanjet.gzq.aflow.model.business;

import com.chanjet.gzq.aflow.server.WFContext;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by David on 2017/2/20.
 * 
 * 会签活动
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountersignTask extends Task implements Serializable {

    public CountersignTask() {

    }

    /* (non-Javadoc)
     * @see com.chanjet.gzq.aflow.model.business.Task#behavior(com.chanjet.gzq.aflow.server.WFContext)
     */
    @Override
    public void behavior(WFContext context) {
      // TODO Auto-generated method stub
      
    }
}
