package hw4;

public class Exponentiation {
    public static void main(String[] args) {
        System.out.println(exp(2, 9));
        System.out.println(exp(2, -2));
        //System.out.println(exp(0, 0));
        System.out.println(exp(-3, 3));
        System.out.println(exp(1, 3));
    }

    private static double exp(double a, int n) {
        if(n == 0 && a != 0) {
            return 1;
        } else if(a == 0 && n == 0){
            throw new IllegalArgumentException("Invalid a " + a + " for n = 0");
        } else if(n == 1){
            return a;
        }

        if(n > 0) {
            return a * exp(a, n - 1);
        } else {
            return 1/(a * exp(a, -n - 1));
        }
    }
}