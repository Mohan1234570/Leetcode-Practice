class Solution {
    public int firstUniqChar(String s) {
        
        int[] countArr = new int[26];

        for(char c : s.toCharArray()){
            countArr[c-'a']++;
        }

        for(int i=0; i<s.length(); i++){
            if(countArr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}