package com.github.ggaier.howtokotlin._01_classes;

import com.github.ggaier.howtokotlin._03_functions.StringUtil;
import com.github.ggaier.howtokotlin._03_functions.StringUtilKt;
import kotlin.text.StringsKt;

/**
 * Created by wenbo, 2018/5/17
 */
public class JPerson {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
