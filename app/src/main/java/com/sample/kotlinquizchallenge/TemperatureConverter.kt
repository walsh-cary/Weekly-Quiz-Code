package com.sample.kotlinquizchallenge

/*
*
* Write a higher-order function that can convert between Celsius and Fahrenheit.
*
* convertTemperature(25.0, celsiusToFahrenheit) //needs to be a higher order function
* convertTemperature(98.6, fahrenheitToCelsius)
*
* // Expected Output
* 25.0 → 77.0
* 98.6 → 37.0
* */

fun main() {
    println(convertTemperature(25.0, celsiusToFahrenheit()))
    println(convertTemperature(98.6, fahrenheitToCelsius()))
}

fun celsiusToFahrenheit(): (Double) -> Double {
    return { temp -> (temp * 9 / 5) + 32 }
}

fun fahrenheitToCelsius(): (Double) -> Double {
    return { temp -> (temp - 32) * 5 / 9 }
}

fun convertTemperature(temp: Double, conversion: (Double) -> Double): Double {
    return conversion(temp)
}