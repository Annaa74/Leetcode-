class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                ans += i * i;
            }
        }
        return ans;
    }

    private boolean isValid(int num) {
        long sq = (long) num * num;
        String s = String.valueOf(sq);
        return backtrack(s, 0, num);
    }

    private boolean backtrack(String s, int index, int target) {
        if (index == s.length()) {
            return target == 0;
        }

        long currentNum = 0;
        for (int i = index; i < s.length(); i++) {
            currentNum = currentNum * 10 + (s.charAt(i) - '0');
            if (backtrack(s, i + 1, target - (int)currentNum)) {
                return true;
            }
        }
        return false;
    }
}