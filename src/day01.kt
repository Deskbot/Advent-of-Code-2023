import java.io.File

fun day01 () {
    var input = File("inputs/day01.txt").readText()

    part1(input)
    part2(input)
}
private fun part1(input: String) {
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

private var numbers = hashMapOf(
    "zero" to 0,
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9,
)

private fun part2(input: String) {
    var sum = 0

    for (line in input.split("\n")) {
        if (line.isEmpty()) continue

        sum += Line(line).value
    }

    println(sum)
}

private class Line(line: String) {
    private var firstNum: Int? = null
    private var lastNum : Int? = null
    var value: Int
        private set

    init {
        var i = -1
        while (true) {
            i += 1
            if (i >= line.length) break

            var ch = line[i]

            if (ch.code >= '0'.code && ch.code <= '9'.code) {
                var chVal = ch.digitToInt()
                processNumber(chVal)

            } else {
                var restOfString = line.substring(i)

                for (numStr in numbers.keys) {
                    if (restOfString.startsWith(numStr)) {
                        i += numStr.length - 1 // subtract 1 because the loop increments anyway
                        val num = numbers[numStr]
                        processNumber(num!!)
                    }
                }
            }
        }

        value = firstNum!! * 10 + lastNum!!
    }

    private fun processNumber(num: Int) {
        if (firstNum == null) {
            firstNum = num
        }

        lastNum = num
    }
}