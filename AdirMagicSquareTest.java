/*
 * Created by: Adir Buskila
 * required Classes: MagicSquare
 * if you find any bugs at the test please notify me :)
 */

public class AdirMagicSquareTest {
        private static int testNumber = 0;

        public static void main(String[] args) {
                System.out.println("---MagicSquare Tester---");
                int[][] mat = {
                                { 2, 9, 4 },
                                { 7, 5, 3 },
                                { 6, 1, 8 }
                };
                int[][] mat1 = {
                                { 1, 1, 1 },
                                { 1, 1, 1 },
                                { 1, 1, 1 }
                };
                int[][] mat2 = {
                                { 2, 2, 2 },
                                { 2, 2, 2 },
                                { 2, 2, 2 }
                };
                int[][] mat3 = {
                                { 2, 2, 2 },
                                { 2, 1, 2 },
                                { 2, 2, 2 }
                };
                int[][] mat4 = {
                                { 2, 2, 2, 7 },
                                { 2, 2, 2, 7 },
                                { 2, 2, 2, 7 }
                };
                int[][] mat5 = {
                                { 2, 9, 4, 1 },
                                { 7, 5, 3, 2 },
                                { 6, 1, 8, 3 } };
                int[][] mat6 = {
                                { -2, -9, -4 },
                                { -7, -5, -3 },
                                { -6, -1, -8 } };
                int[][] mat7 = {
                                { 4, 14, 15, 1 },
                                { 9, 7, 6, 12 },
                                { 5, 11, 10, 8 },
                                { 16, 2, 3, 13 }
                };

                System.out.println("---Testing sumCol---");
                System.out.println("---mat---");
                test(MagicSquare.sumCol(mat, 0) == 15);
                test(MagicSquare.sumCol(mat, 1) == 15);
                test(MagicSquare.sumCol(mat, 2) == 15);
                System.out.println("---mat1---");
                test(MagicSquare.sumCol(mat1, 0) == 3);
                test(MagicSquare.sumCol(mat1, 1) == 3);
                test(MagicSquare.sumCol(mat1, 2) == 3);
                System.out.println("---mat2---");
                test(MagicSquare.sumCol(mat2, 0) == 6);
                test(MagicSquare.sumCol(mat2, 1) == 6);
                test(MagicSquare.sumCol(mat2, 2) == 6);
                System.out.println("---mat3---");
                test(MagicSquare.sumCol(mat3, 0) == 6);
                test(MagicSquare.sumCol(mat3, 1) == 5);
                test(MagicSquare.sumCol(mat3, 2) == 6);
                System.out.println("---Testing sumRow---");
                System.out.println("---mat---");
                test(MagicSquare.sumRow(mat, 0) == 15);
                test(MagicSquare.sumRow(mat, 1) == 15);
                test(MagicSquare.sumRow(mat, 2) == 15);
                System.out.println("---mat1---");
                test(MagicSquare.sumRow(mat1, 0) == 3);
                test(MagicSquare.sumRow(mat1, 1) == 3);
                test(MagicSquare.sumRow(mat1, 2) == 3);
                System.out.println("---mat2---");
                test(MagicSquare.sumRow(mat2, 0) == 6);
                test(MagicSquare.sumRow(mat2, 1) == 6);
                test(MagicSquare.sumRow(mat2, 2) == 6);
                System.out.println("---mat3---");
                test(MagicSquare.sumRow(mat3, 0) == 6);
                test(MagicSquare.sumRow(mat3, 1) == 5);
                test(MagicSquare.sumRow(mat3, 2) == 6);
                System.out.println("---Testing sumPrimaryDiag---");
                System.out.println("---mat---");
                test(MagicSquare.sumPrimaryDiag(mat) == 15);
                System.out.println("---mat1---");
                test(MagicSquare.sumPrimaryDiag(mat1) == 3);
                System.out.println("---mat2---");
                test(MagicSquare.sumPrimaryDiag(mat2) == 6);
                System.out.println("---mat3---");
                test(MagicSquare.sumSecondaryDiag(mat3) == 5);
                System.out.println("---Testing sumSecondaryDiag---");
                System.out.println("---mat---");
                test(MagicSquare.sumSecondaryDiag(mat) == 15);
                System.out.println("---mat1---");
                test(MagicSquare.sumSecondaryDiag(mat1) == 3);
                System.out.println("---mat2---");
                test(MagicSquare.sumSecondaryDiag(mat2) == 6);
                System.out.println("---mat3---");
                test(MagicSquare.sumSecondaryDiag(mat3) == 5);
                System.out.println("---Testing isMagicSquare---");
                System.out.println("---mat---");
                test(MagicSquare.isMagicSquare(mat));
                System.out.println("---mat4---");
                test(!MagicSquare.isMagicSquare(mat4));
                System.out.println("---mat5---");
                test(!MagicSquare.isMagicSquare(mat5));
                System.out.println("---mat6---");
                test(!MagicSquare.isMagicSquare(mat6));
                System.out.println("---mat7---");
                test(MagicSquare.isMagicSquare(mat7));
        }

        private static void test(boolean testCondition) {
                String msg;
                if (testCondition) {
                        msg = "OK";
                } else {
                        msg = "ERROR";
                }
                System.out.println("TestNum: " + (++testNumber) + " " + msg);
        }
}