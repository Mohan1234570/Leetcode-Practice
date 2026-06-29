class Solution {

    int sum = 0;


    public int subsetXORSum(int[] nums) {

        findSubsets(nums,0,0);

        return sum;
    }


    public void findSubsets(int[] nums,
                            int index,
                            int xor){


        // base case
        if(index == nums.length){

            sum += xor;

            return;
        }


        // don't pick
        findSubsets(nums,index+1,xor);


        // pick
        findSubsets(nums,index+1,xor ^ nums[index]);

    }
}