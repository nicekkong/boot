package com.nicekkong.boot.kotiln.thisandthat

import org.junit.Test


class TestSubject{
    val testName:String = "TEST_SUBJECT"

    fun method() {
        println("Test method")
    }
}

public class MyTest {
    var subject: String = ""

   fun setup() {
        subject = TestSubject().toString()
    }

//    @Test
    fun test() {
//        subject.setup()  // dereference directly
    }
}

// Functional Interface (Sigle Abstract Method Interface)
fun interface IntPredicate {
    fun accept(i:Int):Boolean
}

val isEven = object: IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }

}

val isEvenRight = IntPredicate { it % 2 == 0}

fun printHello(name: String?): Unit {
    if (name != null)
        println("Hello $name")
    else
        println("Hi there!")
    // `return Unit` or `return` is optional
}

infix fun String.addComma(x:String): String {

    return "$this::::$x"
}

fun main() {

    println("nicekkong".addComma("world"))
}


