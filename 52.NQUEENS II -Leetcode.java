public class Solution {
    public int totalNQueens(int n) {
        char[][] arr = new char[n][n];

        // Initialize the board
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = '.'; // Initially, we print "."
            }
        }

        return nQueens(arr, 0); // Recursive call to count solutions
    }

    private int nQueens(char[][] arr, int row) {
        if (row == arr.length) {
            return 1; // Found a valid configuration
        }
        int count = 0; // Counter for solutions
        for (int col = 0; col < arr[0].length; col++) {
            if (isSafe(arr, row, col)) { // Check if it is safe to place at this position
                arr[row][col] = 'Q'; // Place the queen
                count += nQueens(arr, row + 1); // Recur to place queens in the next row
                arr[row][col] = '.'; // Reset to initial '.' for backtracking
            }
        }
        return count; // Return the total count of valid configurations
    }

    private boolean isSafe(char[][] arr, int row, int col) { // Function to check if placing is safe for the Queen
        // Checking column
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 'Q') { // Check if 'Q' is present in the same column
                return false;
            }
        }
        // Diagonal 1 (upright diagonal)
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr[0].length; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        // Diagonal 2 (down-left diagonal)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        return true; // Safe to place the queen
    }
}
