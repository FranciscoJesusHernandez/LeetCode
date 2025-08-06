function minPatches(nums: number[], n: number): number {
    let patches = 0;
    let lastReached = 0;
    
    for (const a of nums) {
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
};