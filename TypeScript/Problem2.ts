function minPatches(nums: number[], n: number): number {
    let c = 0;
    let last = 0;
    for (const a of nums) {
        if (a > n) break;

        while (last + 1 < a) {
            last = 2 * last + 1;
            c++;
        }

        last += a;
    }

    while (last < n) {
        last += last + 1;
        c++;
    }

    return c;
};