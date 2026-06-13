class Solution {
    int pos = 0;
    public String decodeString(String s) {
        
        StringBuilder sb = new StringBuilder();
        while(pos<s.length() && s.charAt(pos) != ']'){
            if(Character.isDigit(s.charAt(pos))){
               int num = 0;
               while(Character.isDigit(s.charAt(pos))){
                num = num*10+(s.charAt(pos)-'0');
                pos++;
               }
               pos++;
               String decoded = decodeString(s);
               pos++;
               for(int i = 0; i<num; i++){
                   sb.append(decoded);
               }
            }else{
               sb.append(s.charAt(pos));
               pos++;
            }
        }

        return sb.toString();
    }
}