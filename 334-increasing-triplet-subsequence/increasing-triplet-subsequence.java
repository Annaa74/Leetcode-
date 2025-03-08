class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num; // Update the smallest number
            } else if (num <= second) {
                second = num; // Update the second smallest number
            } else {
                // Found a number larger than both first and second
                return true;
            }
        }

        return false; // No increasing triplet found
    }
}
