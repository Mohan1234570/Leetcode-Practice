class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Not enough flowers overall
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int b : bloomDay){
            low = Math.min(low,b);
            high = Math.max(high,b);
        }
        int ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(canMake(bloomDay,m,k,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean canMake(int[] bloomDay, int m, int k, int mid){
        int count = 0; int bouqets =0;

        for(int blom : bloomDay){
            if(blom<=mid){
                count++;
                if(count ==k){
                    bouqets++;
                    count =0;   
                }

            }else{
              count =0;
            }
        }

        return bouqets>=m;
    }

}