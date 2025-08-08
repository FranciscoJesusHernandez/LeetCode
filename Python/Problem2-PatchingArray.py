class Solution(object):
    def minPatches(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        patches = 0
        lastReached = 0

        for a in nums:
            if a > n:
                break
            
            while lastReached + 1 < a:
                lastReached = 2 * lastReached + 1
                patches = patches + 1
            
            lastReached = lastReached + a
        
        while lastReached < n:
            lastReached = 2 * lastReached + 1
            patches = patches + 1
        
        return patches