import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static void main(String[] args) {
        int base, height;
        double area;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter base, height: ");
        base = input.nextInt();
        height = input.nextInt();

        area = ParallelogramArea(base, height);

        System.out.format("rea of Parallelogram is  = %.1f", area);
    }

    public static double ParallelogramArea(double base, double height) {
        return (base * height);
    }
}
