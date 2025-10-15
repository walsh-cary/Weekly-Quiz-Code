package com.sample.kotlinquizchallenge

/*
*
* Write a function that removes all vowels from a string, case-insensitive.
*
* // Input
* removeVowels("Hello World")
* removeVowels("Kotlin Programming")
*
* // Expected Output
* "Hello World" → "Hll Wrld"
* "Kotlin Programming" → "Ktln Prgrmmng"
* */

fun main() {
    println(removeVowels("Hello World"))
    println(removeVowels("Kotlin Programming"))
}

fun removeVowels(string: String) : String {
    val vowels = setOf("a", "e", "i", "o", "u")
    val charList = string.split("")
        .filter { it !in vowels }

    return charList.joinToString("")
}