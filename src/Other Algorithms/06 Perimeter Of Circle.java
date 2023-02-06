import java.util.Scanner;

public class CirclePerimeter {
  public static final double PI = 3.14159;

  public static double calculateCircumference(double radius) {
    return 2 * PI * radius;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the radius of the circle: ");
    double radius = scanner.nextDouble();
    double circumference = calculateCircumference(radius);
    System.out.println("The circumference of a circle with radius " + radius + " is " + circumference);
  }
}
