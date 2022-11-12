public class MagicSquare {
    public static int sumRow(int[][] mat, int rowNumber) {
        int sum = 0;
        int[] row = mat[rowNumber];
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }
        return sum;
    }

    public static int sumCol(int[][] mat, int colNumber) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            int[] curRow = mat[i];
            for (int j = 0; j < curRow.length; j++) {
                if (j == colNumber) {
                    sum += curRow[j];
                }
            }
        }
        return sum;
    }

    public static int sumPrimaryDiag(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            int[] curRow = mat[i];
            for (int j = 0; j < curRow.length; j++) {
                if (i == j) {
                    sum += curRow[j];
                }
            }
        }
        return sum;
    }

    public static int sumSecondaryDiag(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            int[] curRow = mat[i];
            for (int j = 0; j < curRow.length; j++) {
                if (i + j == mat.length - 1) {
                    sum += curRow[j];
                }
            }
        }
        return sum;
    }

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
