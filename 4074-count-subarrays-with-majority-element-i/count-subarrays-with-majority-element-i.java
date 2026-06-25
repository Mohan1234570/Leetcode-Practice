class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count=0;
        for(int i = 0; i<nums.length; i++){
            int subCount = 0;
            for(int k=i; k<nums.length; k++){
                 if(nums[k] == target){
                    subCount++;
                 }
                 int length =  k-i+1;

                 if(subCount>length/2){
                    count++;
                 }
            }
        }

        return count;
    }
}