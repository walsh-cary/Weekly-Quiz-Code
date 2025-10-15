package com.sample.kotlinquizchallenge

/*
* Find the most frequently occurring word, ignoring common stop words.
*
* // Input
* findMostCommonWord("The sun shines and the sky is blue and clear")
*
* // Expected Output
* "The sun shines and the sky is blue and clear" → "and"
*
* */

fun main() {
    println(findMostCommonWord("The sun shines and the sky is blue and clear"))
    println(findMostCommonWord("The sky is blue and the sky is vast"))
    println(findMostCommonWord("The world is beautiful and the world is strange"))
}

fun findMostCommonWord(string: String) : String? {
    // create a set of stop words, these can be any words we decide on
    val stopWords = setOf(
        "a", "an", "the", "and", "or", "but", "is", "are", "was", "were",
        "of", "in", "on", "at", "to", "for", "with", "from", "by", "i",
        "you", "he", "she", "it", "we", "they", "my", "your", "his", "her",
        "its", "our", "their", "this", "that", "these", "those"
    )

    // create a list of words in the string, filtering out stop words
    val wordList = string.split(" ")
        .map { it.lowercase() }
        .filter { it.isNotBlank() && it !in stopWords }

    // get frequency of each word and create a map of key/value pairs
    val wordFrequency = wordList.groupingBy { it }.eachCount()

    return wordFrequency.maxByOrNull { it.value }?.key
}