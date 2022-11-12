import java.util.Scanner;

/*
 * Adir Buskila
 * 11/10/2022
 * The program takes 3 sides on a triangle and:
 * 1) prints the sides of the triangle
 * 2) prints the perimeter triangle
 * 3) prints the area of the triangle
 */
public class Triangle1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program calculates the area and the perimeter of a given triangle. ");
        System.out.println("Please enter the three lengths of the triangle's sides");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        double s = (Math.sqrt((a + b + c) * (a + b - c) * (b + c - a) * (c + a - b))) / 4;

        System.out.println("The lengths of the triangle sides are: " + a + ", " + b + ", " + c);
        System.out.println("The perimeter of the triangle is: " + (a + b + c));
        System.out.println("The area of the triangle is: " + s);
        scan.close();
    } // end of method main
} // end of class Triangle