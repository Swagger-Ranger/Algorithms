/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Squeeze
 * Author:   liufei32@outlook.com
 * Date:     2018/10/12 15:28
 * Description: 
 * Aha-eureka:
 *******************************************************************************/

package mylib;

public class Squeeze {
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
        return new String(a, 0, n);   //实质就是将字符串重复的字符压缩，然后返回压缩后大小的字字符串
    }


    public static void main(String[] args) {
//        System.out.println(-5%3);
//        System.out.println(1/2);

        System.out.println(Squeeze.squeeze("this is    a    test"));
        System.out.println(Squeeze.squeezeAll("thissss is    a    test"));
    }
}
