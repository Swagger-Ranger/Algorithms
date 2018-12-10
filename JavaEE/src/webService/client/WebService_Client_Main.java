package webService.client;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: WebService_Client_Main
 * Author:   liufei32@outlook.com
 * Date:     2018/12/3 0:30
 * Description: webservce示例client入口类
 * Aha-eureka:
 *******************************************************************************/

public class WebService_Client_Main {

    public static void main( String[] args ) {
        //1.先创建一个用于产生WebServiceImpl实例的工厂，WebServiceImplService类是工具生成的
        WebServiceServerImplService webServiceServerImplService = new WebServiceServerImplService();
        //2.通过工厂生成一个 需要调用的server端的类的实例这里就是client，也是工具生成的--这里的两个类（WebServiceServerImplService，
        //  和WebServiceServerImpl工厂类和实例类都是工具生成的，而这里client的类只是给调用server端的方法时封装数据用的，真正调用的client方法是在
        //  WebServiceServerImpl类的实例中调用getWebServiceServerImplPort()方法获得
//        WebServiceServerImpl wssi = webServiceServerImplService.getWebServiceServerImplPort();
        WebServiceServerImpl wssi = webServiceServerImplService.getWebServiceServerImplPort();
                //3.再调用server端的方法
                String greetings = wssi.greet("Swagger-Ragner");
        System.out.println("this is greetings:" + greetings);
        String greetingsReverse = wssi.reverseString("Swagger-Ranger");
        System.out.println("this is reverse:" + greetingsReverse);
    }
}
