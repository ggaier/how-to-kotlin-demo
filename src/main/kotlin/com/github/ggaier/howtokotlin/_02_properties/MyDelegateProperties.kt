package com.github.ggaier.howtokotlin._02_properties

import kotlin.reflect.KProperty


//Customize

var p1: String = "initial"
    get() {
        println("read property 1")
        return field
    }

var p2: String = "initial"
    get() {
        println("read property 2")
        return field
    }

var p3: String = "initial"
    get() {
        println("read property 3")
        return field
    }

val p4 by Prop("initial")
val p5 by Prop("initial")
val p6 by Prop("initial")


/**
 * operator overloading. 是有固定名字的方法。重载需要前缀 operator
 */
class Prop(var filed: String) {

    operator fun getValue(thisRef: Any?, p: KProperty<*>): String {
        println("read property")
        return filed
    }

    operator fun setValue(thisRef: Any?, p: KProperty<*>, v: String) {
        println("write property ")
        filed = v
    }

}