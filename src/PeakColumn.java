public class PeakColumn {
    // Method to find the peak-columns in the matrix
    public static void findPeakColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Iterate through each row 
        for (int i = 0; i < rows; i++) {
            // Step 1: Find the maximum element in the current row
            int maxInRow = matrix[i][0];
            int maxColIndex = 0;

            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] > maxInRow) {
                    maxInRow = matrix[i][j];
                    maxColIndex = j;
                }
            }

            // Step 2: Check if the max element in the row is the minimum in its column
            boolean isMinInCol = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][maxColIndex] < maxInRow) {
                    isMinInCol = false;
                    break;
                }
            }

            // If the element is both the max in its row and the min in its column, print it
            if (isMinInCol) {
                System.out.println("(" + (i + 1) + "," + (maxColIndex + 1) + ") = " + maxInRow);
            }
        }
    }

    public static void main(String[] args) {
        // Sample matrix A
        int[][] matrix = {
                {12, 2, 4},
                {17, 10, 1},
                {92, 80, 79}
        };

        // Call the method to find and also print peak-columns
        findPeakColumns(matrix);
    }
}
