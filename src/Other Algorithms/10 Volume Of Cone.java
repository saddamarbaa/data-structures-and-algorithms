import java.util.Scanner;

public class RhombusPerimeter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the side length of the rhombus: ");
    double sideLength = scanner.nextDouble();
    double perimeter = 4 * sideLength;
    System.out.println("The perimeter of the rhombus is: " + perimeter);
  }
}
