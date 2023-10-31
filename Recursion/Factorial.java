package Recursion;

public class Factorial {

    public static int findFactorial(int number) {
        if(number == 1) return 1;
        return number * findFactorial(number-1);
    }
    public static void main(String[] args) {
        int result = findFactorial(4);
        System.out.println(result);
    }
}
