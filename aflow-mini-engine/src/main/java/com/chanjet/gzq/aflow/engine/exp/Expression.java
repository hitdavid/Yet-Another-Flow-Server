package com.chanjet.gzq.aflow.engine.exp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by David on 2017/2/24.
 */
public class Expression {

    private static String ExpressionPattern = "(>|>=|<|<=)[0-9.]+|(==|!=)[\\u0391-\\uFFE50-9a-zA-Z.]+|[*]";

    private String plainText;

    private ArrayList<String> exps;

    private Expression() {
        exps = new ArrayList<>();
    }

    public static Expression buildFromText(String text) {

        Expression exp = new Expression();

        if(text.indexOf(',') < 0){

            if(! formatChecker(text, ExpressionPattern)) {
                return null;
            }
            exp.plainText = text;
            exp.getExps().add(exp.plainText);
        }
        else {
            String[] exps = text.split(",");
            boolean legal = false;

            for(String piece : exps) {
                if(! formatChecker(piece.trim(), ExpressionPattern)) {
                    return null;
                }
                exp.getExps().add(piece);
            }
        }
        return exp;
    }

    private static boolean formatChecker(String maybeAnExp, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(maybeAnExp);
        if( !matcher.matches()) {
            return false;
        }
        return true;
    }

    public boolean calc(String fieldValue, Class type) {

        for (String ex : this.exps) {

            BigDecimal result = null;

        }

        return true;
    }

    public ArrayList<String> getExps() {
        return exps;
    }

    public void setExps(ArrayList<String> exps) {
        this.exps = exps;
    }

    public static void main(String[] args) {

        Expression ex = Expression.buildFromText("==1");

        boolean b = ex.calc("1", Integer.class);

        System.out.println(b);
    }

}
