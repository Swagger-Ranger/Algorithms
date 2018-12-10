package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


    public static int strStr(String source, String target) {
        // Write your code here
        int location = -1;

        /*
        * O(n^2)级别的最直观的方法
        * */
        for (int i = 0; i < target.length(); i++) {
//            location = -1;
            
        }
        return location;
    }


    //编写一个程序，它将一个字符串作为输入并删除相邻的空格，最多在一行中留出一个空格
    public static String squeeze(String s) {
        char[] a = s.toCharArray();
        int n = 1;
        for (int i = 1; i < a.length; i++) {
            a[n] = a[i];
            if      (a[n]   != ' ') n++;
            else if (a[n-1] != ' ') n++;
        }
        return new String(a, 0, n);
    }

    public static String squeezeAll(String s) {
        char[] a = s.toCharArray();
        int n = 1;
        for (int i = 1; i < a.length; i++) {
            char odd = a[n - 1];
            a[n] = a[i];
            if (a[i] !=odd) n++;
        }
        return new String(a, 0, n);
    }


    public static void ifTest(int i) {

        if (i < 5) {
            HelloIfTest();
            return;
        }
        System.out.println("Holly shit!");
    }

    private static void HelloIfTest() {
        System.out.println("Hello ifTest!  i'm in!");

    }

    public static void main(String[] args) {
//        System.out.println(-5%3);
//        System.out.println(1/2);

//        System.out.println(Test.squeeze("this is    a    test"));
//        System.out.println(Test.squeezeAll("thissss is    a    test"));
//        ifTest(4);

//        System.out.println((int)'Ѐ');


        String o = "0";
        System.out.println(Integer.valueOf(o));
//        System.out.println(o == null);

    }
}
