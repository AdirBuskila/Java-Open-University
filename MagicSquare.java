/*
 * by: Adir Buskila
 */

public class MagicSquare {
    /*
     * public static int sumRow(int[][] mat,
     * int row)
     * summing all the numbers in a given mat and a given row number
     * Parameters:
     * mat - matrix of integers
     * row - row number in the matrix
     */
    public static int sumRow(int[][] mat, int row) {

        int sum = 0;
        int[] currentRow = mat[row];
        for (int i = 0; i < mat[row].length; i++) {
            sum += currentRow[i];
        }
        return sum;
    }

    /*
     * public static int sumCol(int[][] mat,
     * int col)
     * summing all the numbers in a given mat and a given column number
     * Parameters:
     * mat - matrix of integers
     * col - col number in the matrix
     */
    public static int sumCol(int[][] mat, int col) {

        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            int[] curRow = mat[i];
            for (int j = 0; j < mat[0].length; j++) {
                if (j == col) {
                    sum += curRow[j];
                }
            }
        }
        return sum;
    }

    /*
     * public static int sumPrimaryDiag(int[][] mat)
     * summing the primary diagonal numbers (top-left to bottom-right)
     * Parameters:
     * mat - matrix of integers
     */
    public static int sumPrimaryDiag(int[][] mat) {

        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            int[] curRow = mat[i];
            for (int j = 0; j < mat[0].length; j++) {
                if (i == j) {
                    sum += curRow[j];
                }
            }
        }
        return sum;
    }

    /*
     * public static int sumSecondaryDiag(int[][] mat)
     * summing the primary diagonal numbers (top-right to bottom-left)
     * Parameters:
     * mat - matrix of integers
     */
    public static int sumSecondaryDiag(int[][] mat) {

        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            int[] curRow = mat[i];
            for (int j = 0; j < mat[0].length; j++) {
                if (i + j == mat.length - 1) {
                    sum += curRow[j];
                }
            }
        }
        return sum;
    }

    /*
     * public static boolean isMagicSquare(int[][] mat)
     * checking if a given matrix of numbers is a magic square be these rules:
     * if the sum of the rows, the sum of the columns,
     * the sum of the primary diagonal and the sum of the secondary diagonal
     * are the same then it's a magic square
     * mat - matrix of integers
     */
    public static boolean isMagicSquare(int[][] mat) {

        int sumRow;
        int sumCol;
        int sumPrimary = sumPrimaryDiag(mat);
        int sumSecondary = sumSecondaryDiag(mat);
        for (int i = 0; i < mat.length; i++) {
            sumRow = sumRow(mat, i);
            sumCol = sumCol(mat, i);
            if (sumRow != sumPrimary || sumSecondary != sumCol || sumPrimary != sumSecondary) {
                return false;
            }
        }
        return true;
    }

}
