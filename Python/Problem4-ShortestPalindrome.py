class Solution(object):
    def shortestPalindrome(self, s):
        base = 31
        mod = int(1e9) + 7
        
        hashF = 0
        hashR = 0
        power = 1
        maxLength = 0

        i = 0;
        for ch in s:
            ch = ord(ch) - ord('a') + 1

            hashF = (hashF * base + ch) % mod
            hashR = (hashR + power * ch) % mod

            power = (power * base) % mod

            if hashF == hashR:
                maxLength = i + 1

            i += 1

        suffix = s[maxLength:]
        suffix = suffix[::-1]
        
        return suffix + s
