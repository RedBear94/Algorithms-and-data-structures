package hw4;

public class Exponentiation {
    public static void main(String[] args) {
        System.out.println(exp(2, 10));
    }

    private static int exp(int a, int n) {
        return exponentiation(a, n, a);
    }

    private static int exponentiation(int a, int n, int t) {
        if(n == 0) {
            return 1;
        } else if(n == 1){
            return a;
        }
        return exponentiation(a * t, n - 1, t);
    }
}