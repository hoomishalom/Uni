import java.util.Scanner;
import java.lang.Math;

public class triangle
{
public static void main (String [] args)
{
    Scanner scan = new Scanner(System.in);
    System.out.println ("This program calculates the area and the perimeter of a given triangle. ");
    System.out.println ("Please enter the three lengths of the triangle's sides");
    int sideA = scan.nextInt();
    int sideB = scan.nextInt();
    int sideC = scan.nextInt();

    // checking if sides are valid
    if (!(sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA)) {
        System.out.println("The given three sides don't represent a triangle");
        return;
    }

    int permineter = sideA + sideB + sideC;

    double p = permineter / 2.0;
    double  area = Math.sqrt(p*(p - sideA)*(p - sideB)*(p - sideC));
    
    System.out.print("The perimeter of the triangle is: ");
    System.out.println(permineter);
    System.out.print("The area of the triangle is:");
    System.out.println(area);

    }
}