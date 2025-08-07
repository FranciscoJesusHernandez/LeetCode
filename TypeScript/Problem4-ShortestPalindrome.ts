function shortestPalindrome(s: string): string {
    const base: bigint = BigInt(31);
    const mod: bigint = BigInt(1e9 + 7);

    let hashF: bigint = BigInt(0);
    let hashR: bigint = BigInt(0);
    let power: bigint = BigInt(1);
    let maxLength = 0;

    for(let i = 0; i < s.length; i++){
        let ch: bigint = BigInt(s.charCodeAt(i) - 'a'.charCodeAt(0) + 1);

        hashF = (hashF * base + ch) % mod;
        hashR = (hashR + power * ch) % mod;

        power = (power * base) % mod;

        if(hashF === hashR){
            maxLength = i + 1;
        }
    }

    let suffix = s.slice(maxLength);
    suffix = suffix.split('').reverse().join('');
    
    return suffix + s;

};