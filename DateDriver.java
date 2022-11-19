import java.util.Scanner;

public class DateDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program demonstrates the "
                + "usage of Date class.");
        System.out.println("Please enter the day, month, year"
                + " of the first date");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        Date d1 = new Date(day, month, year);
        Date d2 = new Date(d1.getDay(), d1.getMonth(), d1.getYear());
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        if (d1.equals(d2)) {
            System.out.println("Same Date");
        } else {
            System.out.println("Different Dates");
        }
        d1.setMonth(6);
        System.out.println("Updated month in d1: " + d1.getMonth());
        d2.setYear(d2.getYear() + 1);
        System.out.println("Updated year in d2: " + d2.getYear());
        System.out.println("Updated d2 = " + (d2.getDay() < 9 ? "0" + d2.getDay() : d2.getDay()) + "/"
                + (d2.getMonth() < 9 ? "0" + d2.getMonth() : d2.getMonth()) + "/" + d2.getYear());
        if (d1.equals(d2)) {
            System.out.println("Same Date");
        } else if (d2.before(d1)) {
            System.out.println("Before: " + d2);
            System.out.println("After: " + d1);

        } else {
            System.out.println("Before: " + d1);
            System.out.println("After: " + d2);
        }
        scanner.close();
    } // end of method main
} // end of class DateDrive
