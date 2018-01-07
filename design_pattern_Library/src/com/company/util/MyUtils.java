package com.company.util;

/**
 * Created by me on 01/02/2017.
 */
public class MyUtils {
    public static boolean getBooleanFromInt(Integer a){
        if (a == null || a == 0){
            return false;
        }else{
            return true;
        }
    }
}
