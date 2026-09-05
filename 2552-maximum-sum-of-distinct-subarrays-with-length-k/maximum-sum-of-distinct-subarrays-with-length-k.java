class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long sum =0;

        int left =0;

        Set<Integer> hs = new HashSet<>();

        for(int right =0; right<nums.length; right++){

            while(hs.contains(nums[right])){
                hs.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            hs.add(nums[right]);
            sum += nums[right];

             while(hs.size() == k){
                max = Math.max(max,sum);
                hs.remove(nums[left]);
                sum = sum- nums[left];
                left++;
             }
           
        }
        return max; 
    }
}