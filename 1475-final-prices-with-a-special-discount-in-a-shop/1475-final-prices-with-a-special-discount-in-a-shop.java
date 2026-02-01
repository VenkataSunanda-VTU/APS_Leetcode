import java.util.*;
class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            ans[i] = prices[i];
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                ans[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }
        return ans;
    }
}
