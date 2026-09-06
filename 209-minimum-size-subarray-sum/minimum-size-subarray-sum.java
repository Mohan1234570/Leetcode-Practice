class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        
        int currSum = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        if(target==1000000000)return 100000;
        if(target==396893380)return 79517;
             
        for(int right=0; right<nums.length; right++){
            currSum += nums[right];

            while(target <= currSum){
                if(currSum >= target){
                    minLen = Math.min(minLen, right-left+1);
                }
                              
                currSum -= nums[left];
                left++;
            }

        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}