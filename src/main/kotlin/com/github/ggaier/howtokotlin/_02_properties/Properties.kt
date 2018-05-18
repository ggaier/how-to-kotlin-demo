package com.github.ggaier.howtokotlin._02_properties

//properties 和 field 的区别。 主要在于 property access syntax
private var prop: String = ""
    set(value) {
        println("new value $value")
        field = value
    }
    get() {
        println("get value $field")
        return field
    }

//Delegate Properties
//lazy delegate
private val os: String by lazy {
    println("computing ...")
    "os.name ${System.getProperty("os.version")}"
}

fun main(args: Array<String>) {
    for (i in 1..5) {
        println("os is $os")// computing one type
    }
}

