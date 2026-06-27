class Solution {

    public int maximumLength(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }


        int ans = 1;


        for(int x : map.keySet()) {


            // handle 1 separately
            if(x == 1){

                int c = map.get(1);

                if(c % 2 == 0)
                    ans = Math.max(ans, c - 1);
                else
                    ans = Math.max(ans, c);

                continue;
            }


            long curr = x;

            int len = 0;


            while(true){

                if(!map.containsKey((int)curr))
                    break;


                int count = map.get((int)curr);


                // if only one occurrence,
                // this becomes the middle
                if(count == 1){

                    len++;

                    break;
                }


                // need pair
                len++;

                curr = curr * curr;


                if(curr > 1000000000)
                    break;
            }


            // We need at least one pair
            if(len > 0){

                ans = Math.max(ans, len * 2 - 1);
            }
        }


        return ans;
    }
}