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
        Date d7 = new Date(22, 1, 2000);
        Date d8 = new Date(25, 1, 2000);
        Date d9 = new Date(29, 1, 2000);
        Car carA = new Car(123456789, 'A', "Ford", false);
        Car carB = new Car(123456789, 'B', "Ford", false);
        Car carC = new Car(123456789, 'C', "Ford", false);
        Car carD = new Car(123456789, 'D', "Ford", false);
        Rent r1 = new Rent("Rent 1", carA, d1, d2);
        Rent r2 = new Rent("Rent 2", carA, d2, d3);
        Rent r3 = new Rent("Rent 3", carA, d3, d4);
        Rent r4 = new Rent("Rent 4", carA, d4, d5);
        Rent r5 = new Rent("Rent 5", carA, d5, d6);
        Rent r6 = new Rent("Rent 6", carB, d6, d7);
        Rent r7 = new Rent("Rent 7", carC, d7, d8);
        Rent r8 = new Rent("Rent 8", carD, d8, d9);
        Company c = new Company();
        c.addRent("Rent 8", carC, d8, d9);
        c.addRent("Rent 7", carC, d7, d8);
        c.addRent("Rent 6", carC, d6, d7);
        c.addRent("Rent 5", carC, d5, d6);
        c.addRent("Rent 4", carC, d4, d5);
        c.addRent("Rent 3", carC, d3, d4);
        c.addRent("Rent 2", carB, d2, d3);
        c.addRent("Rent 1", carA, d1, d2);
        System.out.println(c);
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
