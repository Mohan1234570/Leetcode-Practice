class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum =0;

        Map<Integer,Integer> hm = new  HashMap<>();
        hm.put(0,1);

        for(int num : nums){
            prefixSum += num;

            if(hm.containsKey(prefixSum-k)){
                count += hm.get(prefixSum-k);
            }

            hm.put(prefixSum,hm.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}