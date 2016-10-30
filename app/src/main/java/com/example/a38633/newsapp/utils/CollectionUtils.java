package com.example.a38633.newsapp.utils;

import java.util.Collection;

/**
 * Created by 38633 on 2016/10/28.
 */

public class CollectionUtils {
    public static boolean isNullEmpty(Collection c){
        if (null == c ||c.isEmpty()){
            return true;
        }
        return false;
    }
}
