class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        boolean[] used = new boolean[nums.length+1];
        permuteHelper(nums,ans,al,used);
        return ans;
    }
    public void permuteHelper(int[] nums,List<List<Integer>> ans, List<Integer> al,boolean[] used) {

        if(al.size()==nums.length){
            ans.add(new ArrayList<>(al));
            return;
        }
        for(int i= 0; i<nums.length; i++){
            if(used[i])
              continue;
            used[i] = true;  
            al.add(nums[i]);
            permuteHelper(nums,ans,al,used);
            al.remove(al.size()-1);
            used[i] = false;
        }
    }
}