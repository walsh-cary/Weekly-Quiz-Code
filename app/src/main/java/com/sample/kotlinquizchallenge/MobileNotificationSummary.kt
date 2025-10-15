package com.sample.kotlinquizchallenge

/*
*
* Write a function that takes the number of notifications a user has received and returns a summary string.
*
* Example
* -> 0 -> No Notifications
* -> 3-99 -> You have 3 Notifications
* -> 100+ -> You have Notifications 99+
* */

fun main() {
    println(displayNotifications(0))
    println(displayNotifications(1))
    println(displayNotifications(2))
    println(displayNotifications(3))
    println(displayNotifications(102))
}

fun displayNotifications(notifs: Int) : String {
    return when {
        notifs == 0 -> "No Notifications"
        notifs == 1 -> "You have 1 Notification"
        notifs >= 100 -> "You have Notifications 99+"
        else -> "You have $notifs Notifications"
    }
}