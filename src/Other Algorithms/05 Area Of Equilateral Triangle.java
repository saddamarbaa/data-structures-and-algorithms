import java.util.Scanner;

public class EquilateralTriangleArea {

  public static double calculateArea(double side) {
    return (Math.sqrt(3) / 4) * (side * side);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the length of the side of the equilateral triangle: ");
    double side = sc.nextDouble();

    double area = calculateArea(side);
    System.out.println("The area of the equilateral triangle is: " + area);
  }
}
