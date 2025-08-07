function maxProfit(prices: number[]): number {
    let n = prices.length;
    let m = prices[0];
    let b = 0;
    let dp = new Array<number>();
    dp.push(0);

    for (let i = 1; i < n; i++) {
        if (b < prices[i] - m) b = prices[i] - m;
        if (m > prices[i]) m = prices[i];

        dp.push(b);
    }

    let M = prices[n - 1];
    let B = 0;
    let ans = dp[n - 1];
    for (let i = n - 2; i > 0; i--) {
        if (B < M - prices[i]) B = M - prices[i];
        if (M < prices[i]) M = prices[i];

        if (ans < dp[i - 1] + B) ans = B + dp[i - 1];
    }

    return ans;
};
