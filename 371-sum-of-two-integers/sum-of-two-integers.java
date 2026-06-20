class Solution {
    int carr = 0;
    public int getSum(int a, int b) {
        while(b!=0){
            int s = a ^ b;
            carr = (a&b)<<1; 
            a = s;
            b= carr;
        }

        return a;
    }
}