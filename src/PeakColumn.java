import java.util.ArrayList;
import java.util.List;

public class PeakColumn {
    // This is a method to find and return peak-columns in the matrix
    public static List<int[]> findPeakColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<int[]> peakColumns = new ArrayList<>();  // List to store peak-column coordinates and values

        // Iterating through each row
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

            // If the element is both the max in its row and the min in its column, add it to the list
            if (isMinInCol) {
                peakColumns.add(new int[]{i + 1, maxColIndex + 1, maxInRow});  // Adding 1 for 1-based indexing
            }
        }

        return peakColumns;  // Return the list of peak-columns
    }

    public static void main(String[] args) {
        // Sample matrix A
        int[][] matrix = {
                {12, 2, 4},
                {17, 10, 1},
                {92, 80, 79}
        };

        // Call the method to find and store peak-columns
        List<int[]> peaks = findPeakColumns(matrix);

        // Display the peak-columns
        if (!peaks.isEmpty()) {
            System.out.println("Peak-columns found:");
            for (int[] peak : peaks) {
                System.out.println("Row " + peak[0] + ", Column " + peak[1] + " = " + peak[2]);
            }
        } else {
            System.out.println("No peak-columns found.");
        }
    }
}
