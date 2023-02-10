import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 2 number : ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int result = findHCF(num1, num2);
        System.out.println("The Highest Common Factor of " + num1 + " and " + num2 + " is " + result);

    }


    //    GCD Or HCF
    public static int findHCF(int num1, int num2) {

        int min = Math.min(num1, num2);

        int result = 1;
        while (min != 0) {
            if (num1 % min == 0 && num2 % min == 0) {
                result = min;
                break;
            }
            min--;
        }
        return result;
    }


}
