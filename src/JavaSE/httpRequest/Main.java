package JavaSE.httpRequest;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Main
 * Author:   liufei32@outlook.com
 * Date:     2018/12/6 12:28
 * Description: HttpRequest的测试类
 * Aha-eureka:
 *******************************************************************************/

public class Main {

    public static void main( String[] args ) {
        String sr = HttpRequest.sendPost("http://127.0.0.1:8080/PerformanceServlet", "op=add&uid=10081&amount=2");
        System.out.println(sr);
    }
}
