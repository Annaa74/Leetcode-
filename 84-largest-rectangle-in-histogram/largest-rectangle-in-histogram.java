import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int h = heights[st.pop()];
                int l = st.isEmpty() ? -1 : st.peek();
                int area = (i - l - 1) * h;
                ans = Math.max(ans, area);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int h = heights[st.pop()];
            int l = st.isEmpty() ? -1 : st.peek();
            int area = (n - l - 1) * h;
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
