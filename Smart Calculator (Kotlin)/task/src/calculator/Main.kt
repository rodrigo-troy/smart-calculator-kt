package calculator

fun main() {
    val calculator = Calculator()

    while (true) {
        val input = readln()

        if (input.isBlank()) {
            continue
        }

        if (input == "/exit") {
            println("Bye!")
            break
        }

        if (input == "/help") {
            println("The program calculates simple mathematical expressions.")
            continue
        }

        println(calculator.calculate(input))
    }
}
