package com.github.ggaier.howtokotlin._02_properties

import kotlin.properties.Delegates

var observableProp  by Delegates.observable("a") {
    p, old, new ->
    println("${p.name} goes $old to $new")

}


fun main(args: Array<String>) {
    println("Observable property : ")
    val s = "a"
    observableProp = s
    observableProp = s
    observableProp = "bb"
    observableProp = "ccc"
    observableProp = "dddd"
}