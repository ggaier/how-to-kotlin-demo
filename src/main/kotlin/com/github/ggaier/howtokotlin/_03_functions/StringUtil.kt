package com.github.ggaier.howtokotlin._03_functions

/**
 * 方法的重载和 Extension Function
 * //默认 StringUtil01 是单例
 */
object StringUtil01{

    fun getFirstWord(s: String, separator: String): String {
        val index = s.indexOf(separator)
        return if (index < 0) s else s.substring(0, index)
    }
//    fun getFirstWord(s: String, separator: String = " "): String {
//        val index = s.indexOf(separator)
//        return if (index < 0) s else s.substring(0, index)
//    }

//    fun getFirstWord(s: String): String{
//        return getFirstWord(s, " ")
//    }

}

fun test2(){
    StringUtil01.getFirstWord("test", ",")
}

/**
 * extension function。
 */
//fun String.getFirstWord(separator: String = " "): String{
//    val index = indexOf(separator)
//    return if (index < 0) this else substring(0, index)
//}

/**
 * extension property
 */
val String.firstWord: String
    get() {
        val index = indexOf(" ")
        return if (index < 0) this else substring(0, index)
    }

fun main(args: Array<String>) {
//    println(StringUtil.getFirstWord("Jiang Wenbo"))
//    println(StringUtil.getFirstWord("Jiang Wenbo"))
//    println("Jiang Wenbo".getFirstWord())
    println("Jiang Wenbo".firstWord)

}