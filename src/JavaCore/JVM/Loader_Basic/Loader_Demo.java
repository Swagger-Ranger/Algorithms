package JavaCore.JVM.Loader_Basic;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Loader_Demo
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/7 22:41
 * @Description: 类加载器示例
 * @Aha-eureka:
 *******************************************************************************/

public class Loader_Demo {

    public static void main( String[] args ) {
        /**
         * 1.8:sun.misc.Launcher$AppClassLoader@18b4aac2
         * 11:jdk.internal.loader.ClassLoaders$AppClassLoader@1f89ab83
         */
        System.out.println(ClassLoader.getSystemClassLoader());


        /**
         * 11:jdk.internal.loader.ClassLoaders$PlatformClassLoader@7f63425a
         */
        System.out.println(ClassLoader.getSystemClassLoader().getParent());

        System.out.println(System.getProperty("java.class.path"));

        /**
         * 自定义一个与JDK相同的类来测试
         *
         */
//        java.lang.String a = "swagger-ranger";
//        System.out.println(a.getClass().getClassLoader());
//        System.out.println(a);

    }

}
