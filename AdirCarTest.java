
/*
 * Created by: Adir Buskila
 * required Class: Car
 * if you find any bugs at the test please notify me :)
 */
public class AdirCarTest {

    private static int testNumber = 0;

    public static void main(String[] args) {
        System.out.println("---Car Tester---");
        Car c1 = new Car(0, 'A', "Ford", false);
        Car c2 = new Car(0, 'F', "Ford", false);
        Car c3 = new Car(1234567, 'C', "Ford", false);
        Car c4 = new Car(0, 'A', "Ford", false);
        Car c5 = new Car(5555555, 'B', "Ford", true);
        Car c6 = new Car(6666666, 'C', "Ford", true);
        Car c7 = new Car(7777777, 'F', "Ford", true);
        Car c8 = new Car(8888888, 'A', "Ford", true);
        Car c9 = new Car(0, 'B', "Ford", false);
        Car c10 = new Car(0, 'D', "Ford", false);
        Car c11 = new Car(0, 'D', "Ford", true);
        String c1ToString = "id:1111111 type:A brand:BMW gear:auto";
        String c2ToString = "id:9999999 type:A brand:Ford gear:auto";
        String c3ToString = "id:1234567 type:C brand:Ford gear:auto";
        String c4ToString = "id:9999999 type:A brand:Ford gear:auto";
        String c5ToString = "id:5555555 type:B brand:Ford gear:manual";
        String c6ToString = "id:6666666 type:C brand:Ford gear:manual";
        String c7ToString = "id:7777777 type:A brand:Ford gear:manual";
        String c8ToString = "id:8888888 type:A brand:Ford gear:manual";
        int defaultID = 9999999;
        char defaultType = 'A';
        System.out.println("--Testing Constructor--");
        test(c1.getId() == defaultID);
        test(c1.getId() != 0);
        test(c2.getId() == defaultID);
        test(c2.getType() == defaultType);
        test(c3.getId() == 1234567);
        test(c4.getId() == defaultID);
        System.out.println("--Testing getters--");
        test(c1.getBrand() == "Ford");
        test(c1.isManual() == false);
        System.out.println("--Testing setters--");
        System.out.println("-ID-");
        c1.setId(1);
        test(c1.getId() == defaultID && c1.getId() != 1);
        c1.setId(123456789);
        test(c1.getId() == defaultID && c1.getId() != 123456789);
        c1.setId(1111111);
        test(c1.getId() == 1111111);
        System.out.println("-Type-");
        c1.setType('Z');
        test(c1.getType() == 'A');
        c1.setType('B');
        test(c1.getType() == 'B');
        c1.setType('C');
        test(c1.getType() == 'C');
        c1.setType('D');
        test(c1.getType() == 'D');
        c1.setType('A');
        test(c1.getType() == 'A');
        System.out.println("-Brand-");
        c1.setBrand("BMW");
        test(c1.getBrand() == "BMW");
        System.out.println("--toString--");
        test(c1.toString().equals(c1ToString));
        test(c2.toString().equals(c2ToString));
        test(c3.toString().equals(c3ToString));
        test(c4.toString().equals(c4ToString));
        test(c5.toString().equals(c5ToString));
        test(c6.toString().equals(c6ToString));
        test(c7.toString().equals(c7ToString));
        test(c8.toString().equals(c8ToString));
        System.out.println("--Equals--");
        test(!c1.equals(c2));
        test(c1.equals(c1));
        c7.setId(8888888);
        test(c7.equals(c8));
        System.out.println("--Better--");
        test(c1.better(c3) == false);
        test(c1.better(c1) == false);
        test(c10.better(c10) == false);
        test(c3.better(c1));
        test(c1.better(c8));
        test(c8.better(c1) == false);
        test(c9.better(c1));
        test(c9.better(c3) == false);
        test(c9.better(c10) == false);
        test(c3.better(c5));
        test(c3.better(c6));
        test(c10.better(c1));
        test(c10.better(c3));
        test(c10.better(c5));
        test(c10.better(c11));
        System.out.println("--Worse--");
        test(c1.worse(c3)); //
        test(c3.worse(c1) == false);
        test(c1.worse(c8) == false);
        test(c8.worse(c1)); //
        test(c9.worse(c1) == false);
        test(c9.worse(c3)); //
        test(c9.worse(c10)); //
        test(c3.worse(c5) == false);
        test(c3.worse(c6) == false);
        test(c10.worse(c1) == false);
        test(c10.worse(c3) == false);
        test(c10.worse(c5) == false);
        test(c10.worse(c11) == false);
        System.out.println("--Checking if not returning 'true' if same Car--");
        test(c10.worse(c10) == false);

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
