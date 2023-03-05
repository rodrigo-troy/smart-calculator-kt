package calculator

val twoNumberRegex = Regex("\\s*-?(\\d+)\\s+-?(\\d+)\\s*")
val oneNumberRegex = Regex("\\s*-?(\\d+)\\s*")
fun main() {

    while (true) {
        val input = readln()

        if (twoNumberRegex.matches(input)) {
            println(input.split(" ").sumOf { it.toInt() })
        } else if (oneNumberRegex.matches(input)) {
            println(input.toInt())
        } else if (input == "/exit") {
            println("Bye!")
            break
        }
    }
}
