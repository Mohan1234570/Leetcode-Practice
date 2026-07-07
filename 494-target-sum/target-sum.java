class Solution {
    int currSum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums,0,currSum,target);
    }

    public int backtrack(int[] nums, int index,  int currSum, int target){
          if(index==nums.length){
             if(currSum==target){
                return 1;
             }
             return 0;
          }

          int plus = backtrack(nums,index+1,currSum+nums[index],target);
          int minus = backtrack(nums,index+1,currSum-nums[index],target);

          return plus+minus;
    }
}