package com.example.basebean.base;

/**
 * Created by iningke on 2016/6/4.
 */

public class BasePre  {
    public BasePre(){}
    public static BasePre basePre;
    public static BasePre getInstance(){
        if (basePre==null){
            basePre = new BasePre();
        }
        return basePre;
    }

    public static <T extends BasePre> T getInstance(Class<T> clz){
        try {
            return clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }

}
