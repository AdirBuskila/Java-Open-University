import java.util.Scanner;

public class CarDriver {
    final static private int ID_MAX_DEFAULT = 9999999;
    final static private int ID_MIN = 1000000;
    final static private int INDEX_START = 0;
    final static private char TYPE_DEFAULT = 'A';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Please enter Car information:\nID:(must be seven digits)\nType:(A,B,C,D)\nBrand:(car brand)\nIs Manual:(true or false)");
        int id = scanner.nextInt();
        scanner.nextLine();
        id = (id < ID_MAX_DEFAULT && id > ID_MIN) ? id : ID_MAX_DEFAULT;
        String stringType = scanner.nextLine();
        char type;
        if (stringType.equals("A") || stringType.equals("B") || stringType.equals("C") || stringType.equals("D")) {
            type = stringType.charAt(INDEX_START);
        } else {
            type = TYPE_DEFAULT;
        }
        String brand = scanner.nextLine();
        boolean isManual = scanner.nextBoolean();
        Car c1 = new Car(id, type, brand, isManual);
        System.out.println("Please enter another Car");
        System.out.println(
                "Please enter Car information:\nID:(must be seven digits)\nType:(A,B,C,D)\nBrand:(car brand)\nIs Manual:(true or false)");
        id = scanner.nextInt();
        scanner.nextLine();
        id = (id < ID_MAX_DEFAULT && id > ID_MIN) ? id : ID_MAX_DEFAULT;
        stringType = scanner.nextLine();
        if (stringType.equals("A") || stringType.equals("B") || stringType.equals("C") || stringType.equals("D")) {
            type = stringType.charAt(0);
        } else {
            type = TYPE_DEFAULT;
        }
        brand = scanner.nextLine();
        isManual = scanner.nextBoolean();
        Car c2 = new Car(id, type, brand, isManual);
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        if ((c1.getType() == c2.getType()) && (c1.getBrand() == c2.getBrand())
                && (c1.getIsManual() == c2.getIsManual())) {
            System.out.println("Same car");
        } else {
            System.out.println("Different car");
        }
        c1.setIsManual(!c1.getIsManual());
        System.out.println("c1 updated isManual = " + c1.getIsManual());
        if (c1.better(c2)) {
            System.out.println("Better car:\n" + c1);
        } else if (c2.better(c1)) {
            System.out.println("Better car:\n" + c2);
        }
        scanner.close();
    }
}
