package Day03

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var gammaBinary = ""
        var epsilonBinary = ""

        for (bitIndex in input[0].indices) {
            var zeros = 0
            var ones = 0
            for (lineIndex in input.indices) {
                if (input[lineIndex][bitIndex] == '0') zeros++ else ones++
            }
            if (zeros > ones) {
                gammaBinary += '0'
                epsilonBinary += '1'
            } else {
                gammaBinary += '1'
                epsilonBinary += '0'
            }
        }

        val gamma = gammaBinary.toInt(2)
        val epsilon = epsilonBinary.toInt(2)

        return gamma * epsilon
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("\\Day03\\Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("\\Day03\\Day03")
    println(part1(input))
//    println(part2(input))
}
