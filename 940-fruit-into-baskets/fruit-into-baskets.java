class Solution {
    public int totalFruit(int[] fruits) {
        int res = 0;
        int l =0;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int r=0; r<fruits.length; r++){
            hm.put(fruits[r],hm.getOrDefault(fruits[r],0)+1);

            while(hm.size()>2){
                hm.put(fruits[l],hm.get(fruits[l])-1);
                if(hm.get(fruits[l])==0){
                    hm.remove(fruits[l]);
                }
                l++;
            }
            res  = Math.max(res,r-l+1);
        }

        return res;
    }
}