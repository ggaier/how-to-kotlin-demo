package com.github.ggaier.howtokotlin._04_functional

/**
 * Created by wenbo, 2018/5/24
 *
 * 使用带有 Receiver 的lambda 表达式， 而且当 Receiver 的类型能够根据上下文推断出来的时候，
 * lambda 可以直接作为 function literals (函数字面量)。 这样就可以构造出类似 gradle 中的
 * dsl。
 */
class HTML {

    var body: String = ""
    var image: Image = Image()

    fun body() {

    }

    fun body(text: (String) -> Unit) {

    }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()  // create the receiver object
    html.init()        // pass the receiver object to the lambda
    return html
}

infix fun HTML.body1(text: String){

}


class Image {
    var src: String = ""
}


fun img(init: Image.() -> Unit): Image {
    val image = Image()  // create the receiver object
    image.init()        // pass the receiver object to the lambda
    return image
}

infix fun Image.src(url: String){
    src = url
}


fun main(args: Array<String>) {
    // lambda with receiver begins here
    html {
        body()   // calling a method on the receiver object
        body {"abc"}
        this body1 "abc"
        this.body1("abc")
        body = "abc"
//        image src "http://"
    }
}
