package com.github.ggaier.howtokotlin._04_functional

/**
 * Created by wenbo, 2018/5/24
 */
fun main(args: Array<String>) {
    //range expression, .. 操作符 或者是 rangeTo 方法, 创建一个 range。
    val numbers = (1..100).toList()
//    1.rangeTo(100)

    val list = numbers.filter { it%16==0 }
            .also { print(it) } // 方便调试， 请参考 kotlin standard function
            .map { "0x"+it.toString(16) }

    println(list)

    // 把 lambda 作为最后一个参数传入的好处 和 infix, 来实现 safe builders,
    repeat(6) {
        println(it)
    }
}

//high order function, 可以接受方法作为参数的方法
// 把 lambda 作为最后一个参数传入
fun repeat(times: Int , body: (Int)->Unit){
    // infix 关键字， 可以省略掉"." 符号, 把方法名直接插入到 receiver 和参数之间。
    for(index in 0 until times){
        body(index)
    }
}

//取消注释一下方法可以查看 inline 关键字对 lambda 的优化。
//inline fun repeat(times: Int , body: (Int)->Unit){
//    for(index in 0 until times){
//        body(index)
//    }
//}


