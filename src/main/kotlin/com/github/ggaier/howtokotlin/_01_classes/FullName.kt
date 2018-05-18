package com.github.ggaier.howtokotlin._01_classes

/**
 * Created by wenbo, 2018/5/17
 *
 * 1. equals()/hashCode() pair;
 * 2. toString() of the form "User(name=John, age=42)";
 * 3. componentN() functions corresponding to the properties in their order of declaration;
 * 4. copy() function (see below).
 */
data class FullName(val first: String, val last: String)

//class FullName(val first: String, val last: String)

fun main(args: Array<String>) {
    val name = parseName("Jiang Wenbo")
    //    val first = name[0]
    //    val last = name[1]
    val first = name.first
    val last = name.last
    println("$first, $last")

    if (name != parseName("Jiang Wenbo")) {
        println("Equals does't work. ")
    }
}

fun parseName(name: String): FullName {
    val space = name.indexOf(' ')
    return FullName(name.substring(0, space),
            name.substring(space + 1))
}

//fun parseName(name: String): List<String>{
//    val space = name.indexOf(' ')
//    return listOf(name.substring(0, space),
//            name.substring(space+1))
//}
