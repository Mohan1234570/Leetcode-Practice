class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left =0;

        HashMap<Character,Integer> hm = new HashMap<>();
        for(int right =0; right < n; right++){
            if(hm.containsKey(s.charAt(right)) && hm.get(s.charAt(right)) >= left){
                left = hm.get(s.charAt(right))+1;
            }

            hm.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}