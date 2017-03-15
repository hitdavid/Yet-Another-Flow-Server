package com.chanjet.gzq.aflow.engine.exp;

import java.util.ArrayList;

/**
 * Created by David on 2017/3/1.
 */
public enum Operator {

    EMPTY(0, ""),
    GT(1, ">"),
    GE(2, ">="),
    LT(3, "<"),
    LE(4, "<="),
    EQ(5, "=="),
    NE(6, "!="),
    DEFAULT(7, "*");

    private int value;
    private String name;

    private Operator(int value, String opName) {
        this.value = value;
        this.name = opName;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public static ArrayList<Operator> getAll() {

        ArrayList<Operator> all = new ArrayList<Operator>();
        all.add(Operator.EMPTY);
        all.add(Operator.GT);
        all.add(Operator.GE);
        all.add(Operator.LT);
        all.add(Operator.LE);
        all.add(Operator.EQ);
        all.add(Operator.NE);
        all.add(Operator.DEFAULT);

        return all;
    }

}
