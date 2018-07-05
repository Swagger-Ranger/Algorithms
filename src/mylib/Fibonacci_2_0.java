package mylib;

import algs4_lib.StdOut;

import java.util.Arrays;


public class Fibonacci_2_0 {

    private static long[] f;

    public static long[] getFibArray(int n){
        Fib(n);
        return f;
    }
    public static long  Fib(int N) {
        if (N < 0){
            f=new long[1];
            return 0;
        }else{
            f=new long[N+1];
            return Fib(N,f);
        }
    }

    private static long Fib(int N, long[] f) {

        if (f[N] == 0) {
            if (N == 1) {
                f[N] = 1;
            }
            else if (N > 1) {
                f[N] = Fib(N - 1, f) + Fib(N - 2, f);
            }
        }
        return f[N];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFibArray(12)));
    }

}
