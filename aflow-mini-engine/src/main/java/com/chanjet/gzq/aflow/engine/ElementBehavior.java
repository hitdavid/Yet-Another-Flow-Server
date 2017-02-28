package com.chanjet.gzq.aflow.engine;

import com.chanjet.gzq.aflow.model.business.Task;
import com.chanjet.gzq.aflow.server.WFContext;

import java.util.List;

/**
 * @author zhailz
 *
 * 时间：2017年2月26日 ### 下午1:50:21
 * 
 * NOTE:
 * 每一个元素必须满足三个条件，才能够被引擎所识别：
 * 1. 能找到前一个节点，或者前面的几个节点，或者确定前面没有节点
 * 2. 能找到后一个节点，或者后面的几个节点，或者确定后没有节点
 * 3. 当前节点的动作（例如userTask节点是通知代办人，生成待办任务，startTask的动作是:没有动作，直接找下一个节点（没有动作也是一种动作））
 */
public interface ElementBehavior {
  
  public void behavior(WFContext context);
  
  public List<Task> next();
  
  public List<Task> previous();
}
