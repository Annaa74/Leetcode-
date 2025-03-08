class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int whiteCount = 0;

        // Count white blocks in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }

        // Initialize the minimum number of operations as the count of white blocks in the first window
        int minOperations = whiteCount;

        // Slide the window
        for (int i = k; i < n; i++) {
            // Add the new block and remove the leftmost block of the previous window
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }

            // Update the minimum operations required
            minOperations = Math.min(minOperations, whiteCount);
        }

        return minOperations;
    }
}
