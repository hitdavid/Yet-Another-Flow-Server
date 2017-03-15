package com.chanjet.gzq.rest.app;

import com.chanjet.gzq.aflow.model.business.FlowDefinition;
import com.chanjet.gzq.aflow.model.canvas.FlowModel;
import com.chanjet.gzq.aflow.model.serializer.BPMNSerializer;
import com.chanjet.gzq.aflow.util.JSONExtension;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by David on 2017/2/20.
 */
@RestController
@RequestMapping("/aflow")
public class AFlow {

    @ResponseBody
    @RequestMapping(value = "/definition", method = RequestMethod.POST)
    public String query(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestParam(value = "orgId", required = true) String orgId,
        @RequestParam(value = "userId", required = false) String userId,
        @RequestParam(value = "name", required = true) String name,
        @RequestParam(value = "json", required = true) String json

    ) {

        FlowModel model = JSONExtension.parseObject(json, FlowModel.class);
        model.setJson(json);

        FlowDefinition newFLow = FlowDefinition.create(json);
        boolean canSave = newFLow.isValid();

        if(canSave) {
            model.save();
        }
        
        return "Got it!" + name + " @ " + orgId + " save result is " + canSave + "<br />" + BPMNSerializer
            .toXML(model, newFLow);
    }

    @ResponseBody
    @RequestMapping(value = "/definition", method = RequestMethod.GET)
    public String query(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestParam(value = "orgId", required = true) String orgId,
        @RequestParam(value = "fdId", required = true) String fdId

    ) {

//        String json = FlowDefinition.load(orgId, fdId);
        return "";
    }


}
