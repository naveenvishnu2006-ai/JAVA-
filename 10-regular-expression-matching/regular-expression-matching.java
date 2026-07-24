class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] = does s[0..i) match p[0..j) ?
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // empty string matches empty pattern
        
        // Handle patterns like a*, a*b*, a*b*c* matching an empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char prevPatternChar = p.charAt(j - 2);
                    
                    // Option 1: treat "x*" as matching zero occurrences — skip it entirely
                    dp[i][j] = dp[i][j - 2];
                    
                    // Option 2: if the preceding pattern char matches the current s char,
                    // "x*" can also match one more occurrence
                    if (prevPatternChar == '.' || prevPatternChar == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
                // else: mismatch, dp[i][j] stays false
            }
        }
        
        return dp[m][n];
    }
}