package webService.server;

import javax.xml.ws.Endpoint;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: WebService_Server_Main
 * Author:   liufei32@outlook.com
 * Date:     2018/12/2 23:08
 * Description: webservice的入口类
 * Aha-eureka: 这个需要放在web项目中导入webservice的支持类库才能正常运行
 *******************************************************************************/

public class WebService_Server_Main {
    public static void main( String[] args ) {
        String publishInfo = "http://127.0.0.1:8999/webservice_server";
        Endpoint.publish(publishInfo, new WebService_Server_Impl());
        System.out.println("publish successfully!");
    }
}
