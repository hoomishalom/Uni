// REMARK: missing a short description of the class in the header
// Points: -2
import java.util.Scanner;

public class Congruent {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // REMARK: missing documentation along the code
        // Points: -2
        System.out.println ("Please enter the coordinates of the 3 vertices of the first triangle:");
        System.out.println ("Enter the first vertex (2 real numbers)");
        double t1_x1 = scan.nextDouble();
        double t1_y1 = scan.nextDouble();
        System.out.println ("Enter the second vertex (2 real numbers)");
        double t1_x2 = scan.nextDouble();
        double t1_y2 = scan.nextDouble();
        System.out.println ("Enter the third vertex (2 real numbers)");
        double t1_x3 = scan.nextDouble();
        double t1_y3 = scan.nextDouble();
        
        double t1_side1 = Math.hypot(t1_x1 - t1_x2, t1_y1 - t1_y2);
        double t1_side2 = Math.hypot(t1_x1 - t1_x3, t1_y1 - t1_y3);
        double t1_side3 = Math.hypot(t1_x2 - t1_x3, t1_y2 - t1_y3);
        
        System.out.println ("Please enter the coordinates of the 3 vertices of the second triangle:");
        System.out.println ("Enter the first vertex (2 real numbers)");
        double t2_x1 = scan.nextDouble();
        double t2_y1 = scan.nextDouble();
        System.out.println ("Enter the second vertex (2 real numbers)");
        double t2_x2 = scan.nextDouble();
        double t2_y2 = scan.nextDouble();
        System.out.println ("Enter the third vertex (2 real numbers)");
        double t2_x3 = scan.nextDouble();
        double t2_y3 = scan.nextDouble();

        double t2_side1 = Math.hypot(t2_x1 - t2_x2, t2_y1 - t2_y2);
        double t2_side2 = Math.hypot(t2_x1 - t2_x3, t2_y1 - t2_y3);
        double t2_side3 = Math.hypot(t2_x2 - t2_x3, t2_y2 - t2_y3);

        System.out.println ("The first triangle is (" + t1_x1 + "," + t1_y1 +") (" + t1_x2 + "," + t1_y2 + ") (" + t1_x3 + t1_y3 + ").");
        System.out.println("Its lengths are " + t1_side1 + ", " + t1_side2 + ", " + t1_side3 + ".");
        System.out.println ("The second triangle is (" + t2_x1 + "," + t2_y1 +") (" + t2_x2 + "," + t2_y2 + ") (" + t2_x3 + t2_y3 + ").");
        System.out.println("Its lengths are " + t2_side1 + ", " + t2_side2 + ", " + t2_side3 + ".");

        if ((t1_side1==t2_side1 && t1_side2==t2_side2 && t1_side3==t2_side3) || (t1_side1==t2_side2 && t1_side2==t2_side1 && t1_side3==t2_side3) || (t1_side1==t2_side3 && t1_side2==t2_side2 && t1_side3==t2_side1) || (t1_side1==t2_side1 && t1_side2==t2_side3 && t1_side3==t2_side2) || (t1_side1==t2_side2 && t1_side2==t2_side3 && t1_side3==t2_side1) || (t1_side1==t2_side3 && t1_side2==t2_side1 && t1_side3==t2_side2))
        {
            System.out.println("The triangles are congruent");
        } else {
            System.out.println("The triangles are not congruent");
        }
        scan.close();
    }
}
