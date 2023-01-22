/*
 * Created by: Adir Buskila
 * required Classes: Date, Car, Rent, Company
 * required Methods:
 *  ***ADD THESE METHODS! (CRUCIAL FOR TESTER)***
 * 
 * public int getNumOfRents() {
 *  return _noOfRents;
 *       }
 * 
 * public Rent[] getRents() {
 *        return _rents;
 *   }
 * 
 * *** IMPORTANT! ***
 *  after using the tester remove the methods before submitting
 * 
 * if you find any bugs at the test please notify me :)
 */

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
        Date d10 = new Date(3, 2, 2000);
        Date d11 = new Date(10, 2, 2000);
        Date d12 = new Date(20, 2, 2000);
        Car carA = new Car(123456789, 'A', "Ford", false);
        Car carB = new Car(123456789, 'B', "Ford", false);
        Car carC = new Car(123456789, 'C', "Ford", false);
        Car carD = new Car(123456789, 'D', "Ford", false);
        Rent r1 = new Rent("Rent 1", carA, d1, d2);
        Rent r1After = new Rent("Rent 1 After", carA, d1, d2);
        Rent r1AfterAfter = new Rent("Rent 1 After After", carA, d1, d2);
        Rent r2 = new Rent("Rent 2", carB, d2, d3);
        Rent r3 = new Rent("Rent 3", carC, d3, d4);
        Rent r4 = new Rent("Rent 4", carC, d4, d5);
        Rent r5 = new Rent("Rent 5", carC, d5, d6);
        Rent r6 = new Rent("Rent 6", carC, d6, d7);
        Rent r7 = new Rent("Rent 7", carC, d7, d8);
        Rent r8 = new Rent("Rent 8", carC, d8, d9);
        Rent r10 = new Rent("Rent 10", carC, d10, d11);
        Rent r11 = new Rent("Rent 11", carD, d11, d12);
        String toStringTest = "The company has 11 rents:\n" +
                "Name:Rent 1 From:01/01/2000 To:06/01/2000 Type:A Days:6 Price:600\n" +
                "Name:Rent 2 From:06/01/2000 To:08/01/2000 Type:B Days:3 Price:450\n" +
                "Name:Rent 3 From:08/01/2000 To:10/01/2000 Type:C Days:3 Price:540\n" +
                "Name:Rent 4 From:10/01/2000 To:16/01/2000 Type:C Days:7 Price:1134\n" +
                "Name:Rent 5 From:16/01/2000 To:20/01/2000 Type:C Days:5 Price:900\n" +
                "Name:Rent 6 From:20/01/2000 To:22/01/2000 Type:C Days:3 Price:540\n" +
                "Name:Rent 7 From:22/01/2000 To:25/01/2000 Type:C Days:4 Price:720\n" +
                "Name:Rent 8 From:25/01/2000 To:29/01/2000 Type:C Days:5 Price:900\n" +
                "Name:Rent 9 From:29/01/2000 To:03/02/2000 Type:C Days:6 Price:1080\n" +
                "Name:Rent 10 From:03/02/2000 To:10/02/2000 Type:C Days:8 Price:1314\n" +
                "Name:Rent 11 From:10/02/2000 To:20/02/2000 Type:D Days:11 Price:2472";
        System.out.println("---Testing Constructor---");
        Company c = new Company();
        Company c1 = new Company();
        Company c2 = new Company();
        test(c.getNumOfRents() == 0);
        test(c.getRents().length == 1000);
        c.addRent("Rent 8", carC, d8, d9);
        c.addRent("Rent 7", carC, d7, d8);
        c.addRent("Rent 6", carC, d6, d7);
        c.addRent("Rent 5", carC, d5, d6);
        c.addRent("Rent 4", carC, d4, d5);
        c.addRent("Rent 3", carC, d3, d4);
        c.addRent("Rent 2", carB, d2, d3);
        c.addRent("Rent 1", carA, d1, d2);
        c2.addRent("Rent 1", carA, d1, d2);
        c2.addRent("Rent 1 After", carA, d1, d5);
        c2.addRent("Rent 1 After After", carA, d1, d6);
        System.out.println("---Testing addRent---");
        System.out.println(c2);
        test(c2.getRents()[0].equals(r1));
        test(c2.getRents()[1].equals(r1After));
        test(c2.getRents()[2].equals(r1AfterAfter));
        test(c.getRents()[0].equals(r1));
        test(c.getRents()[1].equals(r2));
        test(c.getRents()[2].equals(r3));
        test(c.getRents()[3].equals(r4));
        test(c.getRents()[4].equals(r5));
        test(c.getRents()[5].equals(r6));
        test(c.getRents()[6].equals(r7));
        test(c.getRents()[7].equals(r8));
        test(c.getRents()[8] == null);
        System.out.println("---Testing removeRent---");
        test(c.removeRent(d2));
        test(!c.removeRent(d2));
        test(!c1.removeRent(d12));
        test(c.getRents()[0].equals(r2));
        test(c.getRents()[1].equals(r3));
        test(c.getRents()[2].equals(r4));
        test(c.getRents()[3].equals(r5));
        test(c.getRents()[4].equals(r6));
        test(c.getRents()[5].equals(r7));
        test(c.getRents()[6].equals(r8));
        test(c.removeRent(d9));
        test(!c.removeRent(d9));
        test(c.getRents()[6] == null);
        System.out.println("---Testing getSumOfPrices---");
        test(c.getSumOfPrices() == 4284);
        test(c1.getSumOfPrices() == 0);
        c.addRent("Rent 8", carC, d8, d9);
        c.addRent("Rent 1", carA, d1, d2);
        test(c.getSumOfPrices() == 5784);
        System.out.println("---Testing getSumOfDays---");
        c.removeRent(d2);
        c.removeRent(d9);
        test(c.getSumOfDays() == 25);
        test(c1.getSumOfDays() == 0);
        c.addRent("Rent 8", carC, d8, d9);
        c.addRent("Rent 1", carA, d1, d2);
        test(c.getSumOfDays() == 36);
        System.out.println("---Testing averageRent---");
        test(c1.averageRent() == 0);
        test(c.averageRent() == 4.5);
        c.addRent("Rent 9", carC, d9, d10);
        test(c.averageRent() == 4.666666666666667);
        c.addRent("Rent 10", carC, d10, d11);
        test(c.averageRent() == 5.0);
        c.addRent("Rent 11", carD, d11, d12);
        test(c.averageRent() == 5.545454545454546);
        System.out.println("---Testing lastCarRent---");
        test(c1.lastCarRent() == null);
        test(c.lastCarRent().equals(carD));
        c.removeRent(d12);
        test(c.lastCarRent().equals(carC));
        c.addRent("Rent 11", carD, d11, d12);
        System.out.println("---Testing longestRent---");
        test(c1.longestRent() == null);
        test(c.longestRent().equals(r11));
        c.removeRent(d12);
        test(c.longestRent().equals(r10));
        c.addRent("Rent 11", carD, d11, d12);
        System.out.println("---Testing mostCommonRate---");
        test(c.mostCommonRate() == 'C');
        test(c1.mostCommonRate() == 'N');
        c1.addRent("Rent 12", carD, d11, d12);
        test(c1.mostCommonRate() == 'D');
        c1.addRent("Rent 13", carA, d11, d12);
        c1.addRent("Rent 14", carA, d11, d12);
        c1.addRent("Rent 16", carA, d11, d12);
        test(c1.mostCommonRate() == 'A');
        c1.addRent("Rent 13", carB, d11, d12);
        c1.addRent("Rent 14", carB, d11, d12);
        c1.addRent("Rent 16", carB, d11, d12);
        test(c1.mostCommonRate() == 'B'); // B > A
        System.out.println("---Testing toString---");
        c1.removeRent(d12);
        c1.removeRent(d12);
        c1.removeRent(d12);
        c1.removeRent(d12);
        c1.removeRent(d12);
        c1.removeRent(d12);
        c1.removeRent(d12);
        test(c1.toString() == "The company has 0 rents.");
        test(c.toString().equals(toStringTest));

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
