class Solution {
    public int kthFactor(int n, int k) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (count == k) {
                    return i;
                }
            }
        }

        // Handle perfect squares and the second half of the factors
        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
             if (n % i == 0) {
                if (i * i != n) { // Avoid counting the square root twice
                    count++;
                    if (count == k) {
                        return n / i;
                    }
                }
            }
        }

        return -1; // Less than k factors
    }
}