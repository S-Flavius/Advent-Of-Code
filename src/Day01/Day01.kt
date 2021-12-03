package Day01

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var lastNum = input[0].toInt()
        var increases = 0
        for (num in input) {
            if (lastNum < num.toInt()) increases++
            lastNum = num.toInt()
        }
        return increases
    }

    fun part2(input: List<String>): Int {
        var lastSum = input[0].toInt() + input[1].toInt() + input[2].toInt()
        var increases = 0
        for (i in 2 until input.size) {
            val sum = input[i - 2].toInt() + input[i - 1].toInt() + input[i].toInt()
            if (lastSum < sum) increases++
            lastSum = sum
        }
        return increases
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
