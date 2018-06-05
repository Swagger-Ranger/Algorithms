package lwx425876.chapter1;

import algs4_lib.Counter;
import algs4_lib.StdIn;
import algs4_lib.StdOut;

public class Tast_chapter1 {
	
	static void task_01() {
		System.out.println((0 + 15) / 2);
		System.out.println(2.0e-6 * 100000000.1);
		System.out.println(2.0e-6+1);//2.0e-6 表示 2.0*10的-6次方
		System.out.println(true && false || true && true);
	}
	
	static void task_02(){
		System.out.println((1 + 2.236) / 2);
		System.out.println(1 + 2 + 3 + 4.0);
		System.out.println(4.1 >= 4);
		System.out.println(1 + 2 + "3");
	}
	
	static void task_03() {
		int a = StdIn.readInt(); //利用io_lib里的公共库能节省很多代码
		int b = StdIn.readInt();
		int c = StdIn.readInt();
		if (a == b && a == c) {
			System.out.println("equals");
		}else {
			System.out.println("not equal");
		}
	}
	
	static void task_05() {
		double x = StdIn.readDouble();
		double y = StdIn.readDouble();
		System.out.println(x > 0 && x < 1 && y > 0 && y < 1);//语句的true或者false不需要加if判断
	}
	
	static void task_06() {
		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++) {
			StdOut.println(f);
			f = f + g;
			g = f - g;
		}
	}
	
	static void task_08() {
		System.out.println('b');//char的ascii值,大写在前，a=97;A=65(10进制)
		System.out.println('b' + 'c');
		System.out.println((char) ('a' + 4));
	}
	
	//第9题使用一个内部类来处理
	private static class task_09 {
		private int inputNumber;
		task_09(int a) {
			inputNumber = a;
		}
		task_09() {
			inputNumber = 1024;
		}
		
		private String transToBinary() {
			String output = "";
			for (int n = inputNumber; n > 0;n /= 2)
				output = (n % 2) + output;
			return output;
			
		}
	}
	
	static void task_11(boolean[][] matrix) {
		System.out.print(' ');
		for (int i = 0; i < matrix[0].length; i++) {
			System.out.print(i);
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(i);
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] ? '*' : ' ');
			}
			System.out.println();
		}
	}
	
	static void task_12() {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = 9 - i;
			System.out.print(a[i]);
		}
		System.out.println();
		for (int i = 0; i < 10; i++) {
			a[i] = a[a[i]];
		}
		for (int i = 0 ; i < 10 ; i ++)
			System.out.print(a[i]);
	}
	
	//输入整数递归返回字符串
	static String task_16(int n) {
		System.out.println(n);
		if (n < 0) return "";
		System.out.println("next");
		return task_16(n -3) +n + task_16(n-2) + n;
	}
	
	//递归返回值，用递归实现乘法
	public static int _18_1(int a, int b) {
		if (b == 0) {
			return 0;
		}
		if (b % 2 == 0) {
			return _18_1(a + a, b / 2);
		}
		return _18_1(a + a, b / 2) + a;
	}

	public static int _18_2(int a, int b) {
		if (b == 0) {
			return 1;
		}
		if (b % 2 == 0) {
			return _18_2(a * a, b / 2);
		}
		return _18_2(a * a, b / 2) * a;
	}
	
	
	
	//fabonacci递归	
	public static long F(int N)
    {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }
    //fabonacci递归	更好的实现，使用了方法的重构，并且使用了数组来保存过程中的值
//	brilliant
    public static long Fib(int N)
    {
        long[] f = new long[N+1];
        return Fib(N, f);
    }

    public static long Fib(int N, long[] f)
    {
        if (f[N] == 0)
        {
            if (N == 1)
                f[N] = 1;
            else if (N > 1)
                f[N] = Fib(N-1, f) + Fib(N-2, f);
        }
        
        return f[N];
    }
//	brilliant
    /////
    
    public static double binomial(int n, int k, double p, Counter c) {

            if (n == 0 && k == 0) return 1.0;
            if (n < 0 || k < 0) return 0.0;
            
            c.increment();
            
            return (1.0 - p) * binomial(n-1, k, p, c) + p * binomial(n-1, k-1, p, c);
        
    }
    
    
    
    
	public static void main(String[] args) {
		/*
		 * _18的入口
		int a = StdIn.readInt();
		int b = StdIn.readInt();

		System.out.println(_18_1(2, 25));
		System.out.println(_18_1(3, 11));
		System.out.println(_18_1(a, b) == a * b);

		System.out.println(_18_2(2, 25));
		System.out.println(_18_2(3, 11));
		System.out.println(_18_2(a, b) == Math.pow(a, b));*/
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}