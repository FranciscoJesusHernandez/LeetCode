class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        m = prices[0]
        b = 0
        dp = [0]

        for price in prices:
            if b < price - m:
                b = price - m
            if m > price:
                m = price

            dp.append(b)

        M = prices[n - 1]
        B = 0
        ans = dp[n]

        for i in range(n - 1, 0, -1):
            price = prices[i]
            if B < M - price:
                B = M - price
            if M < price:
                M = price
            
            if ans < dp[i] + B:
                ans = dp[i] + B
        
        return ans
