class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current plot is empty and its neighbors are also empty or out of bounds
            if (flowerbed[i] == 0 
                && (i == 0 || flowerbed[i - 1] == 0) 
                && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                
                // Plant a flower
                flowerbed[i] = 1;
                count++;
                
                // If we have planted enough flowers, return true
                if (count >= n) {
                    return true;
                }
            }
        }
        
        // If we couldn't plant enough flowers, return false
        return count >= n;
    }
}
