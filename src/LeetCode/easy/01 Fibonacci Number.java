class Solution {
    public static int fib(int n) {
        if (n <= 1) return n;
        int num1 = 0, num2 = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return sum;
    }
}
