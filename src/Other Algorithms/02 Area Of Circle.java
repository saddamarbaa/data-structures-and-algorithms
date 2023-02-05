import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int radius;
        final double pi = 3.142;
        double area;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter radius: ");
        radius = input.nextInt();

        // calculating the area of the circle
        area = pi * radius * radius;

        // printing the area of the circle
        System.out.println("Area of circle is :" + area);

    }
}
