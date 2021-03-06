package com.github.ggaier.howtokotlin._03_functions

import com.github.ggaier.howtokotlin._01_classes.FullName

/**
 * sealed class: 子类必须和父类声明在同一个地方.
 */
sealed class Element
class Container(vararg val children: Element): Element()
class Text(val text: String): Element()
class Container2(vararg val children: Element, val fullName: FullName): Element()

fun Element.extractText(): String{
    return extractText(this, StringBuilder()).toString()
}

fun extractText(e: Element, sb: StringBuilder): StringBuilder {
    if(e is Text){// smart cast, only for val
        sb.append((e.text))
    }else if(e is Container2){
        for(child in e.children){
            val (first, last) = e.fullName
            extractText(child, sb)
        }
    }else{
        error("unrecognized element: $e")
    }
    return sb
}

fun Element.extractText1(): String {
    val sb = StringBuilder()
    fun extractText(e: Element, sb: StringBuilder): StringBuilder {
        if (e is Text) {// smart cast, only for val
            sb.append(e.text)
        } else if (e is Container) {
            for (child in e.children) {
                extractText(child, sb)
            }
        } else {
            error("unrecognized element: $e")
        }
        return sb
    }
    return extractText(this, sb).toString()
}

val element1 = Text("element1")
fun testExtensionFuntion(){
    element1.extractText1()
}

fun Element.extractText2(): String {
    val sb = StringBuilder()
    fun extractText(e: Element){
        if (e is Text) {// smart cast, only for val
            sb.append(e.text)
        } else if (e is Container) {
            for (child in e.children) {
                extractText(child, sb)
            }
        } else {
            error("unrecognized element: $e")
        }
    }
    extractText(this)
    return sb.toString()
}

/**
 * 此时修改 abstract class 为 sealed class
 * sealed class, 类似 enum， 固定的，有限的类型。但是 Enum
 * 是单例。而且所有的 sealed class 的子类都必须在和 sealed class同一个文件中。
 */
fun Element.extractText3(): String {
    val sb = StringBuilder()
    fun extractText(e: Element){
        // switch
        when (e) {
            is Container2 -> print("container")
            //expression
            is Text -> // smart cast, only for val
            {sb.append(e.text)
                println()
            }
            is Container -> for (child in e.children) {
                extractText(child, sb)
            }
        }
        when {
            e is Container2 -> print("container2")
            "a"==e.toString() -> print("true")
        }
    }
    extractText(this)
    return sb.toString()
}

val lambda1: (param1: String, param2: Int) -> FullName = {
    param1, param2 ->
    FullName(param1, param2.toString())
}
val isOdd: (Int) -> Boolean = {
    it % 2 != 0
}
fun isOdd2(x: Int): Boolean {
    return  x % 2 != 0
}
fun isOdd(x: Int) = x % 2 != 0

//
val odds  = listOf(1,2,3)
        .filter(::isOdd)
        .forEach { println(it)}
val odds2 = listOf(1,2,3).filter(isOdd)
val odds3 = listOf(1,2,3).filter {
    it%2 !=0
}



/**
 * callable reference 可以用于：
 * function： a top-level, local, member, or extension function: ::isOdd, String::toInt,
 * property: a top-level, member, or extension property: List<Int>::size
 * constructor: ::Regex
 */
fun Element.extractText4(): String {
    val sb = StringBuilder()
    fun extractText(e: Element){
        when (e) {
            is Text -> // smart cast, only for val
                sb.append(e.text)
            //function reference, 方法的引用。
            is Container -> e.children.forEach(::extractText)
        }
    }
    extractText(this)
    return sb.toString()
}

/**
 * anonymous function, 没有方法名的 function
 */
fun Element.extractText5(): String {
    val sb = StringBuilder()
    val extra =  fun (e: Element){
        when (e) {
            is Text -> // smart cast, only for val
                sb.append(e.text)
            is Container -> e.children.forEach {
                //不能做
            }
            else -> error("unrecognized element: $e")
        }
    }
    extra(this)
    return sb.toString()
}

/**
 * lambda 是一个对象，inline keyword comes in。
 * evernote。
 */


inline fun testInline(process:(String)->Unit){
    process("a")
    println("complete")
}

fun test(){
    testInline {
        it.toInt()
    }
}