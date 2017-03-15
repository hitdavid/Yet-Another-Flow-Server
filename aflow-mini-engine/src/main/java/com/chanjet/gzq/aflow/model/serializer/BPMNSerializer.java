package com.chanjet.gzq.aflow.model.serializer;

import com.chanjet.gzq.aflow.model.business.FlowDefinition;
import com.chanjet.gzq.aflow.model.canvas.FlowModel;
import com.chanjet.gzq.aflow.util.BPMN_Const;

/**
 * Created by David on 2017/3/15.
 */
public class BPMNSerializer {

    public static String toXML(FlowModel model, FlowDefinition def) {

        StringBuilder sb = new StringBuilder();
        sb.append(BPMN_Const.XML_Header);
        sb.append(BPMN_Const.DEF_Header);
        sb.append(def.toXML());
        sb.append(BPMN_Const.FIGURE_HEADER);
        sb.append(model.toXML());
        sb.append(BPMN_Const.FIGURE_END);
        sb.append(BPMN_Const.DEF_END);

        return sb.toString();

    }
}
