class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];

        // Helper function to perform depth-first search
        if (dfs(result, used, 0, n)) {
            return result;
        }
        return new int[0]; // Should never reach here as solution is guaranteed
    }

    private boolean dfs(int[] result, boolean[] used, int index, int n) {
        if (index == result.length) {
            return true;
        }
        if (result[index] != 0) {
            return dfs(result, used, index + 1, n);
        }
        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;
            if (num == 1) {
                result[index] = num;
                used[num] = true;
                if (dfs(result, used, index + 1, n)) return true;
                used[num] = false;
                result[index] = 0;
            } else if (index + num < result.length && result[index + num] == 0) {
                result[index] = result[index + num] = num;
                used[num] = true;
                if (dfs(result, used, index + 1, n)) return true;
                used[num] = false;
                result[index] = result[index + num] = 0;
            }
        }
        return false;
    }
}
