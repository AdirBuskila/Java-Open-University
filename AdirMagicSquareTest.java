/*
 * Created by: Adir Buskila
 * required Classes: MagicSquare
 * if you find any bugs at the test please notify me :)
 */

public class AdirMagicSquareTest {
    private static int testNumber = 0;

    public static void main(String[] args) {
        System.out.println("---MagicSquare Tester---");

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
