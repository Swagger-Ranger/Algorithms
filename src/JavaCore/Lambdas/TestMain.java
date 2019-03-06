package JavaCore.Lambdas;

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

        Predicate<Integer> atLeast5 = x -> x > 5;
        System.out.println(atLeast5.test(4));
    }
}
