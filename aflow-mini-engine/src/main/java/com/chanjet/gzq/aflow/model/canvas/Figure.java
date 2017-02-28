package com.chanjet.gzq.aflow.model.canvas;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by David on 2017/2/20.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Figure implements Serializable {

    private String type;
    private String id;
    private float x;
    private float y;
    private float width;
    private float height;
    private float alpha;

    private String cssClass;
    private String bgColor;
    private String color;
    private String outlineColor;

    private String policy;
    private String router;

    private Integer stroke;
    private Integer radius;
    private Integer outlineStroke;

    private ConnectionPoint source;
    private ConnectionPoint target;

    @JsonProperty("ports")
    private ArrayList<Port> ports;

    private UserProperties userData;

    private ArrayList<Point> vertices;


    public Figure() {
        this.id = UUID.randomUUID().toString();
    }

    public Figure(String uuid) {
        this.id = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOutlineColor() {
        return outlineColor;
    }

    public void setOutlineColor(String outlineColor) {
        this.outlineColor = outlineColor;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public Integer getStroke() {
        return stroke;
    }

    public void setStroke(Integer stroke) {
        this.stroke = stroke;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Integer getOutlineStroke() {
        return outlineStroke;
    }

    public void setOutlineStroke(Integer outlineStroke) {
        this.outlineStroke = outlineStroke;
    }

    public ConnectionPoint getSource() {
        return source;
    }

    public void setSource(ConnectionPoint source) {
        this.source = source;
    }

    public ConnectionPoint getTarget() {
        return target;
    }

    public void setTarget(ConnectionPoint target) {
        this.target = target;
    }

    public ArrayList<Port> getPorts() {
        return ports;
    }

    public void setPorts(ArrayList<Port> ports) {
        this.ports = ports;
    }

    public UserProperties getUserData() {
        return userData;
    }

    public void setUserData(UserProperties userData) {
        this.userData = userData;
    }

    public ArrayList<Point> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Point> vertices) {
        this.vertices = vertices;
    }
}
