package com.chanjet.gzq.aflow.util;

/**
 * Created by David on 2017/3/14.
 */
public class BPMN_Const {

    public static final String XML_Header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

    public static final String DEF_Header = "<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.activiti.org/test\" id=\"Definitions_1\" exporter=\"org.eclipse.bpmn2.modeler.core\" exporterVersion=\"1.2.4.Final-v20160330-1625-B110\">";

    public static final String DEF_END = "</definitions>";

    public static final String FIGURE_HEADER = "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_simpleflow\">\n"
        + "    <bpmndi:BPMNPlane bpmnElement=\"simpleflow\" id=\"BPMNPlane_simpleflow\">";

    public static final String FIGURE_END = "    </bpmndi:BPMNPlane>\n"
        + "  </bpmndi:BPMNDiagram>";
}
