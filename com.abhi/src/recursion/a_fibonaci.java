package recursion;

import java.util.ArrayList;

public class a_fibonaci {

    static void main() {
        System.out.println("ans "+fib(10));
    }

    private static int fib(int i) {
        System.out.println(i);
        if(i<=1) return i;
        return fib(i-1)+ fib(i-2);
    }
}
