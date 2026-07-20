class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int oneStepBack = 2; // ways to reach step 2
        int twoStepsBack = 1; // ways to reach step 1
        
        for (int i = 3; i <= n; i++) {
            int current = oneStepBack + twoStepsBack;
            twoStepsBack = oneStepBack;
            oneStepBack = current;
        }
        
        return oneStepBack;
    }
}