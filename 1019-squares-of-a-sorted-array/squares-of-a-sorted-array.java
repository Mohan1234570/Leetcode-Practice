class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length-1;
        int [] res = new int[n+1];

        int pos = n;
        int left = 0;
        int rigt = n;

        while(left<=rigt){
            int leftsq = nums[left] *nums[left];
            int rigtsq = nums[rigt] *nums[rigt];

            if(leftsq>rigtsq){
                res[pos] = leftsq;
                left++;
            }else{
                res[pos] = rigtsq;
                rigt--;
            }
            pos--;
        }

        return  res;
    }
}