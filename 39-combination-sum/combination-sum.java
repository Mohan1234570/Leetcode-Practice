class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        backtracking(candidates,0,target,ans,al);
        return ans;
    }
    public void backtracking(int[] candidates, int index, int target,List<List<Integer>> ans,List<Integer> al){
          if(index == candidates.length){
              if(target==0){
                ans.add(new ArrayList<>(al));
              }
              return;
          }  

          if(candidates[index]<=target){
              
              al.add(candidates[index]);
              backtracking(candidates,index,target-candidates[index],ans,al);
              al.remove(al.size()-1);
          }
          backtracking(candidates,index+1,target,ans,al);
    }
}