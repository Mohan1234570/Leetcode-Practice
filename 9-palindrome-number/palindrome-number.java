class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending with 0 (except 0 itself) are not palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversedHalf = 0;
        
        // Reverse half of the number
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x = x / 10;
        }
        
        // Check for palindrome:
        // Even length: x == reversedHalf
        // Odd length: x == reversedHalf / 10
        return (x == reversedHalf || x == reversedHalf / 10);
    }
}