fun main() {
    fun part1(input: List<String>): Int {
        var lastNum = input[0].toInt()
        var increases = 0
        for (num in input) {
            if (lastNum < num.toInt()) {
                increases++
            }
            lastNum = num.toInt()
        }
        return increases
    }

    fun part2(input: List<String>): Int {
       return 0
    }

//     test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
