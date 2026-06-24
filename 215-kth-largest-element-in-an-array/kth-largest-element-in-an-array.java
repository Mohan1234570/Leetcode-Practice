class Solution {
    public int findKthLargest(int[] nums, int k) {
       /* 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            pq.offer(nums[i]);

            if(pq.size() > k){
                pq.poll();
            }
        }

       return pq.peek();

       */

       int[] res = new int[20001];
       for(int num : nums){
          res[num+10000]++;
       }

       for(int i= 20000; i>=0; i--){
              if(res[i] > 0){
                k -= res[i];
                if(k < 1){
                    return i - 10000;
                }
              }
       }
       return 0;
    }
}