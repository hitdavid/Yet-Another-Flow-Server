package com.chanjet.gzq.aflow.model.deserailizer;

import com.chanjet.gzq.aflow.model.business.Connection;
import com.chanjet.gzq.aflow.model.business.FlowDefinition;
import com.chanjet.gzq.aflow.model.business.Task;
import com.chanjet.gzq.aflow.model.canvas.ConnectionPoint;
import com.chanjet.gzq.aflow.model.canvas.FlowProperties;
import com.chanjet.gzq.aflow.util.JSONExtension;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by David on 2017/2/21.
 */
public class FlowDeserializer extends StdDeserializer<FlowDefinition> {

    public FlowDeserializer() {
        this(FlowDefinition.class);
    }

    public FlowDeserializer(Class<?> vc) {
        super(vc);
    }

    protected FlowDeserializer(JavaType valueType) {
        super(valueType);
    }

    @Override public FlowDefinition deserialize(
        JsonParser jsonParser,
        DeserializationContext deserializationContext
    ) throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        JsonNode userData = node.get("userData");
        JsonNode canvas = node.get("canvas");

        FlowDefinition flowDefinition = new FlowDefinition();

        FlowProperties up = JSONExtension.parseObject(JSONExtension.convertNodeTreeToString(userData), FlowProperties.class);
        flowDefinition.setUserData(up);

        HashMap<String, Task> tasks = new HashMap<String, Task>();
        HashMap<String, Connection> conns = new HashMap<String, Connection>();
        String packageName = Task.class.getPackage().getName();

        for (int i = 0; i < canvas.size(); i++) {
            JsonNode item = canvas.get(i);
            try {
                String className = item.get("type").asText();
                className = packageName + className.substring(className.lastIndexOf("."));

                Class clz = (Class) Class.forName(className);
                Object o = JSONExtension.parseObject(JSONExtension.convertNodeTreeToString(item), clz);

                if(o instanceof Task) {
                    tasks.put( ((Task)o).getId(), (Task)o);
                }
                else if(o instanceof Connection) {
                    conns.put( ((Connection)o).getId(), (Connection)o);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        for(Connection c : conns.values()) {

            ConnectionPoint p = c.getSource();
            Task t = tasks.get(p.getNode());
            c.setSourceTask(t);
            t.addOutputConnection(c);

            p = c.getTarget();
            t = tasks.get(p.getNode());
            c.setTargetTask(t);
            t.addInputConnection(c);
        }

        flowDefinition.setTaskTable(tasks);
        flowDefinition.setConnectionTable(conns);

        return flowDefinition;
    }
}
