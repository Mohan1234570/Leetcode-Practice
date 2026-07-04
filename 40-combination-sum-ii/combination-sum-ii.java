class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        backtracking(candidates,0,target,ans,al);
        return ans;
    }
    public void backtracking(int[] arr, int index, int target, List<List<Integer>> ans,List<Integer> al){

        if(target==0){
           ans.add(new ArrayList<>(al));
           return;
        }
        for(int i = index; i<arr.length; i++){
            if(i>index && arr[i] == arr[i-1])
                continue;

            if(arr[i]> target)
                break;    
            

            al.add(arr[i]);
            backtracking(arr,i+1,target-arr[i],ans,al);
            al.remove(al.size()-1);
        }    
    }

}