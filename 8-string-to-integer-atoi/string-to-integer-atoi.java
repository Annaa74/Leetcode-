class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Trim leading whitespace
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        int sign = 1;
        int index = 0;
        int result = 0;

        // Check for the sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Convert the digits
        while (index < s.length()) {
            char c = s.charAt(index);

            // Stop conversion at the first non-digit character
            if (c < '0' || c > '9') {
                break;
            }

            int digit = c - '0';

            // Check for overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myAtoi("42"));          // Output: 42
        System.out.println(solution.myAtoi("   -042"));     // Output: -42
        System.out.println(solution.myAtoi("1337c0d3"));    // Output: 1337
        System.out.println(solution.myAtoi("0-1"));         // Output: 0
        System.out.println(solution.myAtoi("words and 987")); // Output: 0
    }
}
