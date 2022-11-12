import java.util.Scanner;

/*
 * Adir Buskila
 * 11/10/2022
 * The program takes 3 sides of the the triangle and checks:
 * 1) that the  the sides can make a valid triangle
 * 2) if its an equilateral triangle
 * 3) if its an isosceles triangle
 * 4) if its an right angle triangle
 * 5) if its a valid triangle and its not 1-4 then its a common triangle
 */
public class Triangle2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter three lengths of a triangle side:");
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int Z = scanner.nextInt();
        // checking if the numbers of less than or equal to zero
        // checking if valid triangle
        if ((X <= 0) || (Y <= 0) || (Z <= 0) || (X + Y < Z) || (X + Z < Y)
                || (Z + Y < X)) {
            System.out.println("The numbers: " + X + ", " + Y + " and " + Z + " cannot represent a triangle");
            scanner.close();
            return;
        } else if ((X == Y) && (X == Z)) { // checking if an equilateral triangle
            System.out.println(
                    "The numbers: " + X + ", " + Y + " and " + Z + " represent an equilateral triangle");
        } else if ((X == Y) || (Y == Z) || (X == Z)) { // checking if isosceles triangle
            System.out.println(
                    "The numbers: " + X + ", " + Y + " and " + Z + " represent an isosceles triangle");

            // checking if right angle triangle by: a^2 + b^2 = c^2
        } else if ((Math.pow(X, 2) + Math.pow(Y, 2) == Math.pow(Z, 2))
                || (Math.pow(X, 2) + Math.pow(Z, 2) == Math.pow(Y, 2))
                || (Math.pow(Z, 2) + Math.pow(Y, 2) == Math.pow(X, 2))) {
            System.out.println(
                    "The numbers: " + X + ", " + Y + " and " + Z + " represent a right-angle triangle");

        } else { // regular triangle
            System.out.println("The numbers: " + X + ", " + Y + " and " + Z + " represent a common triangle");
        }
        scanner.close();
        // Tested for:
        // 3,3,3 2,2,2 5,5,5 Output: The numbers: 3, 3 and 3 represent an equilateral
        // triangle
        // 10,5,5 5,10,5 5,5,10 Output: The numbers: 10, 5 and 5 represent an isosceles
        // triangle
        // 3,4,5 Output: The numbers: 3, 4 and 5 represent a right-angle triangle
        // 1,2,3 12,23,15 Output: The numbers: 1, 2 and 3 represent a common triangle
        // 0,0,0 -4,-20,-50 Output: The numbers: 0, 0 and 0 cannot represent a triangle
    }
}