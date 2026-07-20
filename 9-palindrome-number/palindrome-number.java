class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindromes
        if (x < 0) {
            return false;
        }
        
        // Numbers ending in 0 (except 0 itself) can't be palindromes
        if (x % 10 == 0 && x != 0) {
            return false;
        }
        
        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        
        // Even length: x == reversedHalf
        // Odd length: middle digit doesn't matter, so drop it (reversedHalf / 10)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}