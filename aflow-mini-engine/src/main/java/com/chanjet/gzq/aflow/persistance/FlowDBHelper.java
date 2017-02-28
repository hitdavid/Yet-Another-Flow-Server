package com.chanjet.gzq.aflow.persistance;

/**
 * Created by David on 2017/2/24.
 */
public class FlowDBHelper {

//    private volatile static FlowDBHelper instance;
//
//    public static FlowDBHelper getInstance() {
//
//        if (instance == null) {
//            synchronized (FlowDBHelper.class) {
//                if(instance == null) {
//                    instance = new FlowDBHelper();
//                }
//            }
//        }
//        return instance;
//    }

    private static class FlowDBHelperInstance {
        private static final FlowDBHelper instance = new FlowDBHelper();
    }

    public static FlowDBHelper getInstance() {
        return FlowDBHelperInstance.instance;
    }

    private FlowDBHelper() {
    }

    public boolean saveFlow(String json) {
        return true;
    }

    public String loadFlowDoc(String flowId) {
        return null;
    }




}
