import java.io.File

fun day01() {
    var input = File("inputs/day01.txt").readText()

    var sum = 0

    for (line in input.split("\n")) {
        if (line.isEmpty()) continue

        var firstNum: Int? = null
        var lastNum : Int? = null

        for (ch in line) {
            if (ch.code >= '0'.code && ch.code <= '9'.code) {
                var chVal = ch.digitToInt()

                if (firstNum == null) {
                    firstNum = chVal
                }

                lastNum = chVal
            }
        }

        sum += firstNum!! * 10 + lastNum!!
    }

    println(sum)
}