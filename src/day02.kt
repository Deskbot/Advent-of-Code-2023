fun day02() {
    val input = readInput(2)

    part1(input)
}

private fun part1(input: String) {
    val max = Cubes(12, 13, 14)

    val games = input.split("\n")
        .filter { line -> line.isNotEmpty() }
        .map { line -> parseGame(line) }

    var sumOfIds = 0

    for (game in games) {
        val possible = game.reds.all { n -> n <= max.red }
                && game.greens.all { n -> n <= max.green }
                && game.blues.all { n -> n <= max.blue }

        if (possible) {
            sumOfIds += game.id
        }
    }

    println(sumOfIds)
}

class Cubes(
    val red: Int,
    val green: Int,
    val blue: Int
)

class Game(
    val id: Int,
    val reds: Array<Int>,
    val greens: Array<Int>,
    val blues: Array<Int>,
)

fun parseGame(line: String): Game {
    val gameNumMatchResult = Regex("Game ([0-9]+)").find(line)!!
    val gameNum = gameNumMatchResult.groupValues[1].toInt()

    val redMatches = Regex("([0-9]+) red").findAll(line)
    val greenMatches = Regex("([0-9]+) green").findAll(line)
    val blueMatches = Regex("([0-9]+) blue").findAll(line)

    val reds = redMatches
        .toList()
        .map { matchResult -> matchResult.groupValues[1] }
        .map { str -> str.toInt() }
        .toTypedArray()

    val greens = greenMatches
        .toList()
        .map { matchResult -> matchResult.groupValues[1] }
        .map { str -> str.toInt() }
        .toTypedArray()

    val blues = blueMatches
        .toList()
        .map { matchResult -> matchResult.groupValues[1] }
        .map { str -> str.toInt() }
        .toTypedArray()

    return Game(gameNum, reds, greens, blues)
}
