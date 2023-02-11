// find all prime numbers between 1 and a given integer 'n'
// using the Sieve of Eratosthenes algorithm 

// The time complexity of this algorithm is O(n log log n) and the space complexity is O(n).

import java.util.Scanner;

public class PrimeNumbers{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value for n: ");
        int n = scanner.nextInt();
        findPrimes(n);
    }

    private static void findPrimes(int n) {
        if (n < 2) {
            System.out.println("Invalid value for n. Please enter a value greater than or equal to 2.");
            return;
        }

        boolean[] isComposite = new boolean[n + 1];
        isComposite[0] = true;
        isComposite[1] = true;

        // same as i<= Math.sqrt(n)
        for (int i = 2; (i * i) <= n; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        System.out.print("Prime numbers from 1 to " + n + ": ");


        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (!isComposite[i]) {
                System.out.print(i + "  ");
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
