class Solution {
    public int maxArea(int[] height) {
        int res = 0;

        int left = 0;
        int right = height.length-1;
        
        while(left<right){
           int h = Math.min(height[left],height[right]);

           int width = right-left;

           res = Math.max(res,width*h);
           if(height[left]<height[right]){
              left++;
           }else{
              right--;
           }
        }

        return res;
    }
}