package calculator

/**
 * Created with IntelliJ IDEA.
$ Project: smart-calculator
 * User: rodrigotroy
 * Date: 07-03-23
 * Time: 11:21
 */

class Calculator {
    private val isNumber = Regex("\\s*-?(\\d+)\\s*")
    private val isSpace = Regex("\\s+")
    private val isOperator = Regex("\\s*[-+]+\\s*")
    private val isSum = Regex("\\s*[+]+\\s*")
    private val isSub = Regex("\\s*-+\\s*")

    fun calculate(input: String): Int {
        val tokens = input.split(isSpace)
        var total = 0
        var currentOperator = "+"

        tokens.forEach {
            if (it.matches(isNumber)) {
                if (currentOperator == "+") {
                    total += it.toInt()
                } else if (currentOperator == "-") {
                    total -= it.toInt()
                }
            } else if (it.matches(isOperator)) {
                if (it.matches(isSum)) {
                    currentOperator = "+"
                } else if (it.matches(isSub) && it.length % 2 == 0) {
                    currentOperator = "+"
                } else if (it.matches(isSub) && it.length % 2 == 1) {
                    currentOperator = "-"
                }
            }
        }

        return total
    }
}

