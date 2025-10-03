import java.util.*;

class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;

        backtrack(result, new StringBuilder(), s, target, 0, 0, 0);
        Collections.sort(result); // ensure lexicographically smallest order
        return result;
    }

    private void backtrack(ArrayList<String> result, StringBuilder expr, String s,
                           long target, int index, long currentValue, long lastOperand) {

        // If we reached the end of the string
        if (index == s.length()) {
            if (currentValue == target) {
                result.add(expr.toString());
            }
            return;
        }

        // Try all possible splits for the next operand
        for (int i = index; i < s.length(); i++) {
            // Skip numbers with leading zeros
            if (i != index && s.charAt(index) == '0') break;

            long num = Long.parseLong(s.substring(index, i + 1));
            int lengthBefore = expr.length();

            // If it's the first number, just place it (no operator)
            if (index == 0) {
                expr.append(num);
                backtrack(result, expr, s, target, i + 1, num, num);
                expr.setLength(lengthBefore);
            } else {
                // Addition
                expr.append('+').append(num);
                backtrack(result, expr, s, target, i + 1, currentValue + num, num);
                expr.setLength(lengthBefore);

                // Subtraction
                expr.append('-').append(num);
                backtrack(result, expr, s, target, i + 1, currentValue - num, -num);
                expr.setLength(lengthBefore);

                // Multiplication
                expr.append('*').append(num);
                backtrack(result, expr, s, target, i + 1,
                          currentValue - lastOperand + lastOperand * num,
                          lastOperand * num);
                expr.setLength(lengthBefore);
            }
        }
    }
}
