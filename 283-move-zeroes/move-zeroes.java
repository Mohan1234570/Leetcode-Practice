class Solution {
    public void moveZeroes(int[] nums) {
        // int zeros = 0;
        int i = 0;
        int j =0;
        for(j=0;j<nums.length; j++){
            if(nums[j] != 0){
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i] = temp;
                i++;
            }
        }
        
    }
}