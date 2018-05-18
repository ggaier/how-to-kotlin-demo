package com.github.ggaier.howtokotlin.expressions

class Example(val a: Int, val b : String?, val c: Boolean)

fun main(args: Array<String>) {

    val ex = Example(1, null, true)
    var name = "wenbo"

    with(ex) {
        println("a = $a, b= $b, c=$c")
    }
    val (a, b) = Pair(1,2)

    val map = mapOf("k1" to 1,
            "k2" to 2,
            "k3" to 3)

    // Destructuring declarations, 把一个对象解构成一组变量。
    for((key, value) in map.entries){
        println(" key $key, value $value")
    }




}