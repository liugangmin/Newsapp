package com.example.a38633.newsapp.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by 38633 on 2016/10/22.
 */

public class TUtil {
    public static <T> T get(Object o,int i){
        try{
            //getGen......获得带有泛型的父类
            //type java的所有类型的搞基公共接口，包括原始类型，参数化类型，数组类型，类型变量和基本类型；
            //geta获取参数化类型的数组，泛型可能有多个。
            try {
                return ((Class<T>)((ParameterizedType)(o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }catch (InstantiationException e){

        }catch (ClassCastException e){
            e.printStackTrace();
        }
        return null;
    }


}
