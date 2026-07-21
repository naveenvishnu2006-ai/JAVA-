class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;
        
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }
        
        // All lowercase (0 uppercase), or all uppercase (every letter uppercase)
        if (upperCount == 0 || upperCount == word.length()) {
            return true;
        }
        
        // Otherwise, valid only if exactly the first letter is uppercase
        return upperCount == 1 && Character.isUpperCase(word.charAt(0));
    }
}