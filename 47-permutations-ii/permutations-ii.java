class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
        backtracking(nums,used,ans,al);
        return ans;
    }

    public void backtracking(int[] nums,boolean[] used, List<List<Integer>> ans, List<Integer> al){
        if(al.size()==nums.length){
            ans.add(new ArrayList<>(al));
            return;
        }

            for(int i=0; i<nums.length; i++){
                // Already used in this permutation
            if (used[i])
                continue;
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }    
            al.add(nums[i]);
            used[i] = true;
            backtracking(nums,used,ans,al);
            al.remove(al.size()-1);
            used[i] = false;
        }
        
    }
}