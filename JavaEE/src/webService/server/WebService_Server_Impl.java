package webService.server;

import javax.jws.WebService;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: WebService_Server_Impl
 * Author:   liufei32@outlook.com
 * Date:     2018/12/2 22:58
 * Description: webservice的示例实现类
 * Aha-eureka:
 *******************************************************************************/
@WebService
public class WebService_Server_Impl implements WebService_Server{

    @Override
    public String greet( String name ) {
        String greetings = "Hello ,how are you ";
        return greetings + name;
    }

    @Override
    public String reverseString( String string ) {
        StringBuilder reverseResult = new StringBuilder(string);
        return reverseResult.reverse().toString();
    }
}
