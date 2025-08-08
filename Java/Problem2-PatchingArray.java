class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long lastReached = 0;
        
        for (int a: nums) {
            if (a > n) break;

            while (lastReached + 1 < a) {
                lastReached = 2 * lastReached + 1;
                patches++;
            }

            lastReached += a;
        }

        while (lastReached < n) {
            lastReached += lastReached + 1;
            patches++;
        }

        return patches;
    }
}