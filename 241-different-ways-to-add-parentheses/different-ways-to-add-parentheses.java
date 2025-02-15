import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();

        // Base case: If the expression is a single number
        if (expression.matches("-?\\d+")) {  //Handles both positive and negative single numbers
            result.add(Integer.parseInt(expression));
            memo.put(expression, result); // Memoize single number results
            return result;
        }

        for (int i = 0; i < expression.length(); i++) {
            char op = expression.charAt(i);
            if (op == '+' || op == '-' || op == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);

                for (int leftVal : leftResults) {
                    for (int rightVal : rightResults) {
                        int res = 0;
                        if (op == '+') {
                            res = leftVal + rightVal;
                        } else if (op == '-') {
                            res = leftVal - rightVal;
                        } else if (op == '*') {
                            res = leftVal * rightVal;
                        }
                        result.add(res);
                    }
                }
            }
        }

        memo.put(expression, result); // Memoize the result before returning
        return result;
    }
}