/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: LambdaTest
 * Author:   liufei32@outlook.com
 * Date:     2018/10/21 0:48
 * Description: lambda表达式的学习实例
 * Aha-eureka:
 *******************************************************************************/

package JavaSE.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        String[] s = {"abc", "def", "ghi","bfe","accer"};
        //    ArrayList arrayList = (ArrayList) Arrays.asList(s);
        List<String> lists = Arrays.asList(s);
        //lambda表达式的应用之一：遍历集合
        lists.forEach((listss)->System.out.println(listss + ";"));
        //等价于
        for (String s1 : s) {
            System.out.println(s1 + ";");
        }

        //lambda表达式的应用之一：排序
        Arrays.sort(s, (String s1, String s2) -> (s1.compareTo(s2)));
        //等价于匿名内部类
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.compareTo(o2));
            }
        });
    }

}
