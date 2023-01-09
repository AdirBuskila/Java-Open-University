public class MagicSquare {

    public static int sumRow(int[][] mat, int rowNumber) {
        int matLength = (mat.length < mat[0].length) ? mat.length : mat[0].length;
        int sum = 0;
        int[] row = mat[rowNumber];
        for (int i = 0; i < matLength; i++) {
            sum += row[i];
        }
        return sum;
    }

    public static int sumCol(int[][] mat, int colNumber) {
        int matLength = (mat.length < mat[0].length) ? mat.length : mat[0].length;

        int sum = 0;
        for (int i = 0; i < matLength; i++) {
            int[] curRow = mat[i];
            for (int j = 0; j < matLength; j++) {
                if (j == colNumber) {
                    sum += curRow[j];
                }
            }
        }
        return sum;
    }

    public static int sumPrimaryDiag(int[][] mat) {
        int matLength = (mat.length < mat[0].length) ? mat.length : mat[0].length;

        int sum = 0;
        for (int i = 0; i < matLength; i++) {
            int[] curRow = mat[i];
            for (int j = 0; j < matLength; j++) {
                if (i == j) {
                    sum += curRow[j];
                }
            }
        }
        return sum;
    }

    public static int sumSecondaryDiag(int[][] mat) {
        int matLength = (mat.length < mat[0].length) ? mat.length : mat[0].length;

        int sum = 0;
        for (int i = 0; i < matLength; i++) {
            int[] curRow = mat[i];
            for (int j = 0; j < matLength; j++) {
                if (i + j == matLength - 1) {
                    sum += curRow[j];
                }
            }
        }
        return sum;
    }

    public static boolean isMagicSquare(int[][] mat) {
        int matLength = (mat.length < mat[0].length) ? mat.length : mat[0].length;

        int sumRow;
        int sumCol;
        int sumPrimary = sumPrimaryDiag(mat);
        int sumSecondary = sumSecondaryDiag(mat);
        for (int i = 0; i < matLength; i++) {
            sumRow = sumRow(mat, i);
            sumCol = sumCol(mat, i);
            if (sumRow != sumPrimary || sumSecondary != sumCol || sumPrimary != sumSecondary) {
                return false;
            }
        }
        return true;
    }

}
