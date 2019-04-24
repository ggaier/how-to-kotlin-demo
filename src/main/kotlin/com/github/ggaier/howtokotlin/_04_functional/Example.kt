package com.github.ggaier.howtokotlin._04_functional

import com.github.ggaier.howtokotlin._01_classes.JPerson
import com.github.ggaier.howtokotlin._03_functions.isOdd

data class Example(val a: Int, val b : String?, val c: Boolean)

fun main(args: Array<String>) {

    val ex = Example(1, null, true)
    var name = "wenbo"
    val (first, middle, last) = ex

    //Kotlin standard function. with, apply, let, run, also
    val result: Boolean = with(ex) {
        println("a = $a, b= $b, c=$c")
        println("a = ${isOdd(2)}, b= $b, c=$c")
        true
    }

    val theEx = ex.apply {
        println(ex)
    }
    assert(theEx==ex)

    //declaration
    val (a, b) = Pair(1,2)
    val (c, d) = 1 to 2

    val map = mapOf("k1" to 1,
            "k2" to 2,
            "k3" to 3)


    // Destructuring declarations, 把一个对象解构成一组变量。
    for((key, value) in map.entries){
        println(" key $key, value $value")
    }
    test5(null)
}

fun test2(e: Example): String{
    return when(e.a){
        1 -> "odd"
        2 -> "even"
        3 -> "odd"
        4 -> "even"
        else -> "too big"
    }
}

//如果在 when 表达式中， 多种情况的处理是一致的， 那么 branch condition 可以用 ","
//号组合起来
fun test3(e: Example): String{
    return when(e.a){
        1, 3 -> "odd"
        in setOf(2, 4) -> "even" //在collections或者range 中使用 in 关键字
        else -> "too big"
    }
}

//如果方法只有一个表达式， 那么可以去掉{}
fun test4(e: Example): String = when(e.a){
        1 ,3 -> "odd"
        in setOf(2, 4) -> "even"
        else -> "too big"
    }

// kotlin 中的 nullability
fun test5(str: String?): String?{
    val a: String? = null
    a?.toInt()
    val b: String = "2"
    b.toInt()

//    a!!.toInt()

    val nullablePerson = JPerson()
    nullablePerson.name = null
    nullablePerson.age = null

    println("jperson age: ${nullablePerson.age?.toInt()}")

    //主要有三种处理方式
    //1. 使用 !! 操作符, 这样如果 receiver 是空的情况下， 会抛出 NullPointerException
//    println(str!!.length)

    //2. 使用safe call
    println(str?.length)

    //3. 对 receiver 做 null 检查。
    if (str != null) {
        str.forEach {
            print(it)
        }
    }
    //此处会有 elvis 操作符
    // TextUtils.isEmpty(str)? "null value" :str
    val s = str ?: "null value"
    return str
}
