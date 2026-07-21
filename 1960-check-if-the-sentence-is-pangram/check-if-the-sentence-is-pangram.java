class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
        int uniqueCount = 0;
        
        for (char c : sentence.toCharArray()) {
            int index = c - 'a';
            if (!seen[index]) {
                seen[index] = true;
                uniqueCount++;
            }
        }
        
        return uniqueCount == 26;
    }
}
