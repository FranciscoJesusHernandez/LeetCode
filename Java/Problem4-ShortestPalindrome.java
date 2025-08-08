import java.math.BigInteger;

class Solution {
    public String shortestPalindrome(String s) {
        BigInteger base = new BigInteger("31");
        BigInteger mod = new BigInteger("1000000007"); //1e9 + 7

        BigInteger hashF = new BigInteger("0");
        BigInteger hashR = new BigInteger("0");
        BigInteger power = new BigInteger("1");
        int maxLength = 0;

        int i = 0;
        for (char c : s.toCharArray()){
            // int val = c - 'a' + 1;
            // BigInterger ch = new BigInterger(String.valueOf(val));
            BigInteger ch = BigInteger.valueOf(c - 'a' + 1);

            hashF = hashF.multiply(base).add(ch).mod(mod);
            hashR = hashR.add(power.multiply(ch)).mod(mod);

            power = power.multiply(base).mod(mod);

            if(hashF.equals(hashR)){
                maxLength = i + 1;
            }
            i++;
        }

        String suffix = s.substring(maxLength);
        StringBuilder sb = new StringBuilder(suffix);
        sb.reverse();
        suffix = sb.toString();

        return suffix + s;
    }
}
