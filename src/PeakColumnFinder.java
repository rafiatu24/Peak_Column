import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeakColumnFinder {

    /**
     * Method to find peak-columns in the matrix.
     * A peak-column element is defined as an element that is the maximum in its row and
     * the minimum in its column.
     *
     * @param matrix The input matrix.
     * @return A list of peak-columns, where each peak-column is represented as an int array.
     */
    public static List<int[]> findPeakColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<int[]> peakColumns = new ArrayList<>(); // List to store peak-columns (position and value)

        // Iterate through each row to find peak-column elements
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
                peakColumns.add(new int[]{i + 1, maxColIndex + 1, maxInRow}); // Store 1-based index and value
            }
        }

        return peakColumns; // Return the list of peak-columns
    }

    /**
     * Helper method to handle user input for the matrix.
     * It prompts the user for the dimensions of the matrix and its elements.
     *
     * @return The matrix entered by the user.
     */
    public static int[][] getMatrixInput() {
        Scanner scanner = new Scanner(System.in);
        int rows, cols;

        // Input matrix dimensions and validate them
        try {
            System.out.print("Enter the number of rows: ");
            rows = scanner.nextInt();
            System.out.print("Enter the number of columns: ");
            cols = scanner.nextInt();

            if (rows <= 0 || cols <= 0) {
                System.out.println("Matrix dimensions must be positive integers.");
                return null;
            }

            // Initialize and fill the matrix
            int[][] matrix = new int[rows][cols];
            System.out.println("Enter the matrix elements row by row:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            return matrix;

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter only integers.");
            return null;
        } finally {
            scanner.close();
        }
    }

    /**
     * Main method to execute the program.
     * It obtains the matrix input, finds peak-columns, and displays them.
     */
    public static void main(String[] args) {
        // Obtain matrix input from the user
        int[][] matrix = getMatrixInput();

        // Check if matrix input is valid
        if (matrix == null) {
            System.out.println("No valid matrix provided. Exiting program.");
            return;
        }

        // Find and store the peak-columns
        List<int[]> peaks = findPeakColumns(matrix);

        // Display the peak-columns
        if (!peaks.isEmpty()) {
            System.out.println("Peak-columns found:");
            for (int[] peak : peaks) {
                System.out.println("A (" + peak[0] + "," + peak[1] + ") = " + peak[2]);
            }
        } else {
            System.out.println("No peak-columns found.");
        }
    }
}
