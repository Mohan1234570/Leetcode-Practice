class Solution {
    static final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long evenWays = (n+1)/2;
        long oddWays = n/2;
        
        long even = fastPow(5,evenWays);
        long odd = fastPow(4,oddWays);

        return (int)((even*odd)%MOD);
        
    }
    
    public long fastPow(long base, long exponent){

        long result = 1;

        while(exponent>0){
            if(exponent%2==1){
                result = (result*base)%MOD;
            }

            base = (base*base)%MOD;

            exponent/=2;
        }

        return result;

    }


}