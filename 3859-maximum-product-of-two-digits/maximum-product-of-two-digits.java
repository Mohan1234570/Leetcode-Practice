class Solution {
    public int maxProduct(int n) {
        int first = 0;
        int secod = 0;
        while(n != 0){
            int digit = n%10;
            if(digit>=first){
                secod = first;
                first = digit;
            }else if(digit>secod){
                secod = digit;
            }
            n/=10;
        }

        return first*secod;
    
    }
}