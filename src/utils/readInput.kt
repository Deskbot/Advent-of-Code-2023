import java.io.File

fun readInput(day: Int): String {
    val dayNum = day.toString().padStart(2, '0')
    return File("inputs/day$dayNum.txt").readText()
}