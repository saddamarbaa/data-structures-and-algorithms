import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 2 number : ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int result = findLCM(num1, num2);
        System.out.println("The The Minimum Common Factor of " + num1 + " and " + num2 + " is " + result);

    }


    //    LCM
    public static int findLCM(int num1, int num2) {
        int min = Math.max(num1, num2);
        int result = min;

        while (!(result % num1 == 0 && result % num2 == 0)) {
            result += min;
        }

        return result;
    }


}
