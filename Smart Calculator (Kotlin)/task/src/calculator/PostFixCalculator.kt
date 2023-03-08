package calculator

/**
 * Created with IntelliJ IDEA.
$ Project: smart-calculator
 * User: rodrigotroy
 * Date: 08-03-23
 * Time: 15:34
 */
class PostFixCalculator {
    private val containsParentheses = Regex("\\s*[()]+\\s*")

    fun isInvalidExpression(input: String): Boolean {
        if (input.contains(containsParentheses)) {
            if (input.count { it == '(' } != input.count { it == ')' }) {
                return true
            }
        }

        return false
    }

}
