class Solution {


    public int subarraysWithKDistinct(int[] nums, int k){
        return subarraysWithKDistincthelper(nums,k)-subarraysWithKDistincthelper(nums,k-1);
    }
    public int subarraysWithKDistincthelper(int[] nums, int k) {
        int count = 0;

        int left =0;
        int j=0;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){

           hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
           while(hm.size()>k){
             hm.put(nums[j],hm.get(nums[j])-1);
             if(hm.get(nums[j])==0){
                hm.remove(nums[j]);
             }
             j++;
           }

           count += i-j+1;
        }

        return count;
    }
}