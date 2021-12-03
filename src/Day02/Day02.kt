package Day02

import readInput

fun main() {

    // Delegate -> Both functions are very similar
    fun part1(input: List<String>): Int {
        var pos = 0
        var depth = 0
        for (line in input) {
            val direction = line.split(" ")[0]
            val distance = line.split(" ")[1].toInt()
            when (direction) {
                "forward" -> pos += distance
                "up" -> depth -= distance
                "down" -> depth += distance
            }
        }
        return pos * depth
    }

    fun part2(input: List<String>): Int {
        var pos = 0
        var depth = 0
        var aim = 0

        for (line in input) {
            val direction = line.split(" ")[0]
            val distance = line.split(" ")[1].toInt()
            when (direction) {
                "forward" -> {
                    pos += distance
                    depth += aim * distance
                }
                "up" -> aim -= distance
                "down" -> aim += distance
            }
        }
        return pos * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("\\Day02\\Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("\\Day02\\Day02")
    println(part1(input))
    println(part2(input))
}
