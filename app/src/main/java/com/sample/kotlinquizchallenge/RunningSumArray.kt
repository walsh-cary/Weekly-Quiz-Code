package com.sample.kotlinquizchallenge

/*
* Return a new array where each element is the sum of all previous elements.
*
* // Input
* runningSum(intArrayOf(1, 2, 3, 4))
* runningSum(intArrayOf(3, 1, 2, 10, 1))
*
* // Expected Output
* [1, 2, 3, 4] → [1, 3, 6, 10]
* [3, 1, 2, 10, 1] → [3, 4, 6, 16, 17]
* */

fun main() {
    println(runningSum(intArrayOf(1, 2, 3, 4)))
    println(runningSum(intArrayOf(3, 1, 2, 10, 1)))
}

fun runningSum(nums: IntArray) : List<Int> {
    val newNums = mutableListOf<Int>()
    var sum = 0

    nums.forEach {
        sum += it
        newNums.add(sum)
    }

    return newNums
}