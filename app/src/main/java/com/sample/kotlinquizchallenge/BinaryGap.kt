package com.sample.kotlinquizchallenge

/*
* Find the longest sequence of consecutive zeros in binary representation surrounded by ones.
*
* // Input
* findBinaryGap(9)   // Binary: 1001
* findBinaryGap(529) // Binary: 1000010001
* findBinaryGap(32)  // Binary: 100000
*
* // Expected Output
* 9 → 2
* 529 → 4
* 32 → 0 (no gap surrounded by ones)
* */

fun main() {
    findBinaryGap(9)
    findBinaryGap(529)
    findBinaryGap(32)
}

fun findBinaryGap(number: Int) {
    var binaryString = ""
    var res = number

    while (res > 0) {
        binaryString = (res % 2).toString() + binaryString
        res /= 2
    }

    var longest = 0
    var current = 0

    binaryString.forEach {
        if (it == '1') {
            if (current > longest) {
                longest = current
            }
            current = 0
        }
        if (it == '0') {
            current += 1
        }
    }

    println("$number longest gap is $longest")
}