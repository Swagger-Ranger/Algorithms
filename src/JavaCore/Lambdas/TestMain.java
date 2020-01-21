package JavaCore.Lambdas;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TestMain
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/6 12:07
 * @Description: 测试类
 * @Aha-eureka:
 *******************************************************************************/

public class TestMain {
    public static void main( String[] args ) {

//        Predicate<Integer> atLeast5 = x -> x > 5;
//        System.out.println(atLeast5.test(4));
//
//        FunctionTest test = () -> System.out.println("sssssssssss");
//        test.test();

        String string2Map = "{" +
                "\"abc\":123," +
                "\"efg\":456," +
                "\"hij\":789," +
                "\"xyz\":110" +
                "}";

        Map<String, Integer> result = asList(string2Map.substring(1, string2Map.length() - 1).split(","))
                .stream()
                .collect(Collectors.toMap(x -> x.split(":")[0], x -> Integer.valueOf(x.split(":")[1])));

//        result.forEach(( k, v ) -> System.out.println("key: " + k + ", value: " + v));


//        List<String> lists = new ArrayList<>();
//        List<String> lists = Collections.nCopies(3,"112");
        List<String> lists = new ArrayList<>(asList("123"));
        lists.add("234");
        lists.add("234");
        lists.add("234");
        System.out.println(lists);
    }



}
