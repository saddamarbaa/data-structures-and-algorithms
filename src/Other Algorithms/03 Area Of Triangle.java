import java.util.Scanner;

//Area of triangle = 1/2 × base × height
public class Main {
    public static void main(String[] args) {
        int base,height;
        double area;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter base, height: ");
        base = input.nextInt();
        height = input.nextInt();
        area = 1/2.0 * base * height;


        System.out.println("Area of triangle is :" + area);

    }
}
