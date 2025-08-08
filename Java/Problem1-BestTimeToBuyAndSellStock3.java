class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int m = prices[0];
        int b = 0;
        int dp = new int[n];

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (b < prices[i] - m) b = prices[i] - m;
            if (m > prices[i]) m = prices[i];

            dp[i] = b;
        }

        int M = prices[n - 1];
        int B = 0;
        int ans = dp[n - 1];

        for (int i  = n - 2; i > 0; i--) {
            if (B < M - prices[i]) B = M - prices[i];
            if (M < prices[i]) M = prices[i];

            if (ans < dp[i - 1] + B) ans = B + dp[i - 1];
        }

        return ans;
    }
}