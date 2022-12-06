public class AdirCompanyTest {
    private static int testNumber = 0;

    public static void main(String[] args) {
        System.out.println("---Company Tester---");
        Date d1 = new Date(1, 1, 2000);
        Date d2 = new Date(6, 1, 2000);
        Date d3 = new Date(8, 1, 2000);
        Date d4 = new Date(10, 1, 2000);
        Date d5 = new Date(16, 1, 2000);
        Date d6 = new Date(20, 1, 2000);
        Car carA = new Car(123456789, 'A', "Ford", false);
        Car carB = new Car(123456789, 'B', "Ford", false);
        Car carC = new Car(123456789, 'C', "Ford", false);
        Car carD = new Car(123456789, 'D', "Ford", false);
        Rent r1 = new Rent("Rent 1", carA, d1, d2);
        Rent r2 = new Rent("Rent 2", carA, d1, d3);
        Rent r3 = new Rent("Rent 3", carA, d1, d4);
        Rent r4 = new Rent("Rent 4", carA, d1, d1);
        Rent r5 = new Rent("Rent 5", carA, d1, d5);
        Rent r6 = new Rent("Rent 6", carB, d1, d5);
        Rent r7 = new Rent("Rent 7", carC, d1, d5);
        Rent r8 = new Rent("Rent 8", carD, d1, d5);
        Company c = new Company();
        c.addRent("Rent 1", carA, d1, d2);
        c.addRent("Rent 2", carB, d1, d3);
        c.addRent("Rent 3", carC, d1, d5);
        c.addRent("Rent 4", carC, d1, d6);
        System.out.println(c.getSumOfPrices());
        test(c.getSumOfPrices() == 7061);
        System.out.println(c.averageRent());
        test(c.averageRent() == 11);
        test(c.mostCommonRate() == 'C');
        System.out.println(c.longestRent());
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
