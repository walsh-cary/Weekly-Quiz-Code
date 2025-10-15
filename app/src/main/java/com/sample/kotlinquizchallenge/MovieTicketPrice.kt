package com.sample.kotlinquizchallenge

/*
*
* Create a function that calculates movie ticket price based on age and showtime.
*
* // Input
* calculateTicketPrice(age = 25, isMatinee = false) // Adult, evening
* calculateTicketPrice(age = 70, isMatinee = true)  // Senior, matinee
* calculateTicketPrice(age = 8, isMatinee = false)  // Child, evening
*
* // Expected Output
* 25, false → 15
* 70, true → 8
* 8, false → 8
*
* */

fun main() {
    println(calculateTicketPrice(age = 25, isMatinee = false))
    println(calculateTicketPrice(age = 70, isMatinee = true))
    println(calculateTicketPrice(age = 8, isMatinee = false))
}

fun calculateTicketPrice(age: Int, isMatinee: Boolean) : Int {
    return if (isMatinee || age < 18) 8 else 15
}