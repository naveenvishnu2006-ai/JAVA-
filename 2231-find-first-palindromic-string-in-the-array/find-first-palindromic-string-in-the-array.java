class Solution {
    public String firstPalindrome(String[] words) {
        for (String w : words) {
            if (isPalindrome(w)) {
                return w;
            }
        }
        return "";
    }

    private boolean isPalindrome(String w) {
        int left = 0, right = w.length() - 1;
        while (left < right) {
            if (w.charAt(left) != w.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
