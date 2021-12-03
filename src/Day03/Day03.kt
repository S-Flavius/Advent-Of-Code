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

    fun getZerosAndOnes(input: List<String>, index: Int): List<Int> {
        val zerosOnes = mutableListOf<Int>()
        zerosOnes.add(0)
        zerosOnes.add(0)
        for (number in input) {
            if (number[index] == '0') zerosOnes[0]++ else zerosOnes[1]++
        }
        return zerosOnes
    }

    fun getNumber(input: List<String>, mode: String): Int {
        var lastNumbers = mutableListOf<String>()

        lastNumbers.addAll(input)

        for (index in input.indices) {
            if (lastNumbers.size == 1) return lastNumbers[0].toInt(2)
            val zerosOnes = getZerosAndOnes(lastNumbers, index)

            val goodNumbers = mutableListOf<String>()
            if (mode == "high") {
                if (zerosOnes[0] > zerosOnes[1]) {
                    for (number in lastNumbers)
                        if (number[index] == '0') goodNumbers.add(number)
                } else {
                    for (number in lastNumbers)
                        if (number[index] == '1') goodNumbers.add(number)
                }
            } else {
                if (zerosOnes[0] > zerosOnes[1]) {
                    for (number in lastNumbers)
                        if (number[index] == '1') goodNumbers.add(number)
                } else {
                    for (number in lastNumbers)
                        if (number[index] == '0') goodNumbers.add(number)
                }
            }
            lastNumbers = goodNumbers
        }
        return -1
    }

    fun part2(input: List<String>): Int {
        val oxygen = getNumber(input, "high")
        val scrubber = getNumber(input, "low")

        return oxygen * scrubber
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("\\Day03\\Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("\\Day03\\Day03")
    println(part1(input))
    println(part2(input))
}
