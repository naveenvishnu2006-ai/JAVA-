class Solution {
    public boolean squareIsWhite(String coordinates) {
        int col = coordinates.charAt(0) - 'a'; // 0-indexed column (a=0, b=1, ...)
        int row = coordinates.charAt(1) - '1'; // 0-indexed row (1=0, 2=1, ...)
        
        return (col + row) % 2 == 1;
    }
}