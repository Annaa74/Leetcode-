class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        
        // Calculate prefix products
        int prefix = 1;
        for (int i = 0; i < length; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }
        
        // Calculate suffix products and multiply with prefix products
        int suffix = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        
        return answer;
    }
}
