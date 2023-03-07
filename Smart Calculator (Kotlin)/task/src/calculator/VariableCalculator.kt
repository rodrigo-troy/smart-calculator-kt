package calculator

/**
 * Created with IntelliJ IDEA.
$ Project: smart-calculator
 * User: rodrigotroy
 * Date: 07-03-23
 * Time: 16:57
 */

private val isInvalidIdentifier =
    Regex("\\s*([a-zA-Z]+\\d+[a-zA-Z]*|\\d+[a-zA-Z]+|[a-zA-Z]+\\d+[a-zA-Z]+|[^a-zA-Z0-9]+)\\s*")
private val isSpace = Regex("\\s+")
private val isOperator = Regex("\\s*[-+]+\\s*")
private val isNumber = Regex("\\s*[-+]?(\\d+)\\s*")
private val isVariableDeclaration = Regex("\\s*[a-zA-Z]+\\s*=\\s*[-+]?[\\d|a-zA-Z]+\\s*")
private val isInvalidVariableDeclaration =
    Regex("\\s*([a-zA-Z]+\\d+[a-zA-Z]*|\\d+[a-zA-Z]+|[a-zA-Z]+\\d+[a-zA-Z]+|[^a-zA-Z0-9]+)\\s*=\\s*[-+]?[\\d|a-zA-Z]+\\s*")
private val isVariable = Regex("\\s*[a-zA-Z]+\\s*")

class VariableCalculator {
    private val variablesMap = mutableMapOf<String, String>()

    fun isInvalidVariableDeclaration(input: String): Boolean {
        return input.matches(isInvalidVariableDeclaration)
    }

    fun isVariableMapEmpty(): Boolean {
        return variablesMap.isEmpty()
    }

    fun isVariableDeclaration(input: String): Boolean {
        return input.matches(isVariableDeclaration)
    }

    fun isInvalidIdentifier(input: String): Boolean {
        return input.matches(isInvalidIdentifier)
    }

    fun isVariable(input: String): Boolean {
        return input.matches(isVariable)
    }

    fun variableExists(input: String): Boolean {
        return variablesMap.containsKey(input)
    }

    fun addVariable(input: String) {
        val tokens = input.split("=")
        variablesMap[tokens[0].trim()] = tokens[1].trim()
    }

    fun getVariableValue(input: String): String {
        val variable = variablesMap[input] ?: ""

        if (variable.matches(isNumber)) {
            return variable
        } else {
            return getVariableValue(variable)
        }
    }

    fun getExpresion(input: String): String {
        val tokens = input.split(isSpace)

        var expression = ""
        tokens.forEach {
            if (it.matches(isOperator)) {
                expression += " $it "
            } else if (it.matches(isVariable)) {
                expression += getVariableValue(it)
            } else if (it.matches(isNumber)) {
                expression += " $it "
            }
        }

        return expression
    }
}
