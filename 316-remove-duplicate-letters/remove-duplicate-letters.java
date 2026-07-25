class Solution {
    public String removeDuplicateLetters(String s) {
        boolean [] visited = new boolean[26];
        int [] count = new int [26];

        for(char c: s.toCharArray()){
            count[c-'a']++;
        }

        StringBuilder stack = new StringBuilder();

        for(char ch : s.toCharArray()){
            int index = ch-'a';
            count[index]--;

            if(visited[index]){
                continue;
            }

            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > ch &&
                   count[stack.charAt(stack.length() - 1) - 'a'] > 0) {

                visited[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }

            stack.append(ch);
            visited[index] = true;
        }

        return stack.toString();
    }
}