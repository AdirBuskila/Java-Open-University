import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int speed1 = scanner.nextInt();
        int hour1 = scanner.nextInt();
        double minToHour1 = hour1 / 60.0;
        int distance1 = (int) (minToHour1 * speed1);
        int speed2 = scanner.nextInt();
        int hour2 = scanner.nextInt();
        double minToHour2 = hour2 / 60.0;
        int distance2 = (int) (minToHour2 * speed2);
        System.out.println("The distance between the trains is: " + (Math.abs(distance2 - distance1)));
        scanner.close();
    }
}
