package com.sample.kotlinquizchallenge

/*
*
* Create a Song class with properties and computed properties.
*
* // Input
* val song = Song("Bohemian Rhapsody", "Queen", 2500000, 354)
*
* // Expected Output
* song.formattedDuration → "05:54"
* song.isPopular() → true
*
* */

fun main() {
    val song = Song("Bohemian Rhapsody", "Queen", 2500000, 354)

    println(song.formattedDuration())
    println(song.isPopular())
}

data class Song(
    val name: String,
    val artist: String,
    val numberOfPlays: Int,
    val lengthInSeconds: Int,
)

fun Song.formattedDuration(): String? {
    val minutes = (this.lengthInSeconds / 60).toString()
    val seconds = (this.lengthInSeconds % 60).toString()
    return "$minutes:$seconds"
}

fun Song.isPopular(): Boolean {
    return this.numberOfPlays > 1000000
}