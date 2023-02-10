import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter r: ");
        int r = sc.nextInt();

        BigInteger nPrResult = nPr(n, r);
        BigInteger nCrResult = nCr(n, r);

        System.out.println("nPr Result: " + nPrResult);
        System.out.println("nPr Result: " + nCrResult);
    }

    public static BigInteger nPr(int n, int r) {
       //  nPr = n! / (n - r)!
        BigInteger nFactorial = calculateFactorial(n);
        BigInteger nMinusRFactorial = calculateFactorial(n - r);

        BigInteger result = nFactorial.divide(nMinusRFactorial);
        return result;
    }


    public static BigInteger nCr(int n, int r) {
       // nCr = n! / (r! * (n - r)!)
        BigInteger nFactorial = calculateFactorial(n);
        BigInteger rFactorial = calculateFactorial(r);
        BigInteger nMinusRFactorial = calculateFactorial(n - r);
        return nFactorial.divide(rFactorial.multiply(nMinusRFactorial));
    }

    private static BigInteger calculateFactorial(int n) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            BigInteger currentNumber = BigInteger.valueOf(i);

            factorial = factorial.multiply(currentNumber);
        }

        return factorial;
    }
}
