package math;

public class MathDemo1 {
    public static void main(String[] args) {
        int n = 100;
        boolean b = isPrime(n);
        System.out.println(b);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}