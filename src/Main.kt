package aoc2023

import day01
import day02

fun main(args: Array<String>) {
    var dayStr = args[0]
    var day = dayStr.toInt()

    when (day) {
        1 -> day01()
        2 -> day02()
    }
}
