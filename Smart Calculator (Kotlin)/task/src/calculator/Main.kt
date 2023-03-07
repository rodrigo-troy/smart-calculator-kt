package calculator

private val isUnknowCommand = Regex("/[a-zA-Z]+")
private val isMalformed = Regex("\\s*[0-9]*[-+]+\\s*")

fun main() {
    val calculator = Calculator()
    val variableCalculator = VariableCalculator()

    while (true) {
        val input = readln()

        if (input == "/exit") {
            println("Bye!")
            break
        }

        if (input.isBlank()) {
            continue
        }

        if (input.matches(isUnknowCommand)) {
            println("Unknown command")
            continue
        }

        if (variableCalculator.isInvalidIdentifier(input) || variableCalculator.isInvalidVariableDeclaration(input)) {
            println("Invalid identifier")
            continue
        }

        if (variableCalculator.isVariableDeclaration(input)) {
            variableCalculator.addVariable(input)
            continue
        }

        if (variableCalculator.isVariable(input) && variableCalculator.variableExists(input)) {
            println(variableCalculator.getVariableValue(input))
            continue
        }

        if (variableCalculator.isVariable(input) && !variableCalculator.variableExists(input)) {
            println("Unknown variable")
            continue
        }

        if (input == "/help") {
            println("The program calculates simple mathematical expressions.")
            continue
        }

        if (variableCalculator.isVariableMapEmpty()) {
            println(calculator.calculate(input))
        } else {
            println(calculator.calculate(variableCalculator.getExpresion(input)))
        }
    }
}
