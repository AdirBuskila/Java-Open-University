/*
 * Created by: Adir Buskila
 * required Classes: Date, Car, Rent
 * if you find any bugs at the test please notify me :)
 */

public class AdirRentTest {
    private static int testNumber = 0;

    public static void main(String[] args) {
        System.out.println("--Rent Tester--");
        Date d1 = new Date(1, 1, 2000);
        Date d2 = new Date(6, 1, 2000);
        Date d3 = new Date(8, 1, 2000);
        Date d4 = new Date(10, 1, 2000);
        Date d5 = new Date(16, 1, 2000);
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
        String r1ToString = "Name:Rent 1 From:01/01/2000 To:06/01/2000 Type:A Days:5 Price:500";
        String r2ToString = "Name:Rent 2 From:01/01/2000 To:08/01/2000 Type:A Days:7 Price:630";
        String r3ToString = "Name:Rent 3 From:01/01/2000 To:10/01/2000 Type:A Days:9 Price:830";
        String r4ToString = "Name:Rent 4 From:01/01/2000 To:02/01/2000 Type:A Days:1 Price:100";
        String r5ToString = "Name:Rent 5 From:01/01/2000 To:16/01/2000 Type:A Days:15 Price:1360";
        String r6ToString = "Name:Rent 6 From:01/01/2000 To:16/01/2000 Type:B Days:15 Price:2040";
        String r7ToString = "Name:Rent 7 From:01/01/2000 To:16/01/2000 Type:C Days:15 Price:2448";
        String r8ToString = "Name:Rent 8 From:01/01/2000 To:16/01/2000 Type:D Days:15 Price:3264";

        System.out.println("---Testing constructor---");
        System.out.println("r4 = " + r4);
        test(!r4.getPickupDate().equals(r4.getReturnDate()));
        test(r4.getPickupDate().tomorrow().equals(r4.getPickupDate().tomorrow()));
        Rent rent1 = new Rent(r1);
        System.out.println("---Testing equals---");
        test(r1.equals(rent1));
        test(!r1.equals(r2));
        System.out.println("---Testing howManyDays---");
        test(r1.howManyDays() == 5);
        test(r2.howManyDays() == 7);
        test(r3.howManyDays() == 9);
        test(r4.howManyDays() == 1);
        System.out.println("---Testing getPrice---");
        test(r1.getPrice() == 500);
        test(r2.getPrice() == 630);
        test(r3.getPrice() == 830);
        test(r5.getPrice() == 1360);
        System.out.println("---Testing upgrade---");
        System.out.println("-1-");
        test(r8.upgrade(carD) == 0);
        test(r8.upgrade(carC) == 0);
        test(r8.upgrade(carB) == 0);
        test(r8.upgrade(carA) == 0);
        System.out.println("-2-");
        test(r7.upgrade(carD) == 816);
        r7.setCar(carC);
        test(r7.upgrade(carC) == 0);
        test(r7.upgrade(carB) == 0);
        test(r7.upgrade(carA) == 0);
        System.out.println("-3-");
        test(r6.upgrade(carD) == 1224);
        r6.setCar(carB);
        test(r6.upgrade(carC) == 408);
        r6.setCar(carB);
        test(r6.upgrade(carB) == 0);
        test(r6.upgrade(carA) == 0);
        System.out.println("-4-");
        test(r5.upgrade(carD) == 1904);
        r5.setCar(carA);
        test(r5.upgrade(carC) == 1088);
        r5.setCar(carA);
        test(r5.upgrade(carB) == 680);
        r5.setCar(carA);
        test(r5.upgrade(carA) == 0);
        System.out.println("---Testing toString");
        System.out.println(r1);
        test(r1.toString().equals(r1ToString));
        test(r2.toString().equals(r2ToString));
        test(r3.toString().equals(r3ToString));
        test(r4.toString().equals(r4ToString));
        test(r5.toString().equals(r5ToString));
        test(r6.toString().equals(r6ToString));
        test(r7.toString().equals(r7ToString));
        test(r8.toString().equals(r8ToString));
    }

    private static void test(boolean testCondition) {
        System.out.println("TestNum: " + (++testNumber));
        if (testCondition) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }
}