package calculator

private val isUnknowCommand = Regex("/[a-zA-Z]+")

fun main() {
    val calculator = Calculator()
    val variableCalculator = VariableCalculator()
    val postFixCalculator = PostFixCalculator()

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

        if (postFixCalculator.isInvalidExpression(input)) {
            println("Invalid expression")
            continue
        }

        if (variableCalculator.isInvalidIdentifier(input)) {
            println("Invalid identifier")
            continue
        }

        if (variableCalculator.isInvalidVariableDeclaration(input)) {
            println("Invalid assignment")
            continue
        }

        if (variableCalculator.isVariableDeclaration(input) && variableCalculator.isNotFoundVariableDeclaration(input)) {
            println("Unknown variable")
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
