package com.github.ggaier.howtokotlin._03_functions;

/**
 * Created by wenbo, 2019-04-24
 */
public interface IsOdd {

     boolean isOdd(int params);
}

class IsOddImpl {

    public static boolean isOdd(int params){
        return params%2!=0;
    }

    public static void test(){
        boolean isOdd = IsOddImpl.isOdd(2);
    }
}

