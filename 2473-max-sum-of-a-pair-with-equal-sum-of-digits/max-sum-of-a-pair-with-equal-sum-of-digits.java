import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> maxSum = new HashMap<>(); // Store max sum for each digit sum
        int result = -1;

        for (int num : nums) {
            int digitSum = sumOfDigits(num);

            if (maxSum.containsKey(digitSum)) {
                result = Math.max(result, maxSum.get(digitSum) + num);
                maxSum.put(digitSum, Math.max(maxSum.get(digitSum), num)); //Update max for digitSum
            } else {
                maxSum.put(digitSum, num);
            }
        }

        return result;
    }

    private int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}