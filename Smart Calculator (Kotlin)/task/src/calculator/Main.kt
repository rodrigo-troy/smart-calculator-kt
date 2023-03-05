package calculator

val isNumber = Regex("\\s*-?(\\d+)\\s*")
val isSpace = Regex("\\s+")
fun main() {

    while (true) {
        val input = readln()
        val tokens = input.split(isSpace)

        if (tokens.all { it.matches(isNumber) }) {
            println(tokens.sumOf { it.toInt() })
        } else if (input == "/exit") {
            println("Bye!")
            break
        } else if (input == "/help") {
            println("The program calculates the sum of numbers")
        }
    }
}
