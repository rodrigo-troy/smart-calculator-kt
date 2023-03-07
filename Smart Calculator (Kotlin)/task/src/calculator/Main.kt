package calculator

private val isAlpha = Regex("[a-zA-Z]+")
private val isMalformed = Regex("[^0-9-+\\s]+")
fun main() {
    val calculator = Calculator()

    while (true) {
        val input = readln()

        if (input == "/exit") {
            println("Bye!")
            break
        }

        if (input.isBlank()) {
            continue
        }

        if (input.contains(isAlpha)) {
            println("Invalid expression")
            continue
        }

        if (input.contains(isMalformed)) {
            println("Invalid expression")
            continue
        }

        if (input == "/help") {
            println("The program calculates simple mathematical expressions.")
            continue
        }

        println(calculator.calculate(input))
    }
}
