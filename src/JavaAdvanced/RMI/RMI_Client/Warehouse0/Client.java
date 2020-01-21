package JavaAdvanced.RMI.RMI_Client.Warehouse0;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.util.Enumeration;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Client
 * @Author: liufei32@outlook.com
 * @Date: 2019/5/11 19:12
 * @Description: RMI的client类
 * @Aha-eureka:
 *******************************************************************************/

public class Client {

    public static void client( String RMI_URL, String SERVICE_NAME, String param ) throws NamingException {

        System.out.println("-------client-------------");

        Context namingContext = new InitialContext();

        //查询RMI注册表，并打印所有的绑定服务
        Enumeration<NameClassPair> e = namingContext.list(RMI_URL);
        while (e.hasMoreElements()) {

            System.out.println(e.nextElement().getName());
        }

        //获取对应地址上的服务
        String url = RMI_URL + SERVICE_NAME;
        Warehouse centralWarehouse = (Warehouse)namingContext.lookup(url);

        //获取给定参数的结果
//        String param = "the book of Java_RMI";
        double price = centralWarehouse.getPrice(param);
        System.out.println(price);
    }

    public static void main( String[] args ) throws NamingException {

        String url = "rmi://127.0.0.1:8001/";
        String servername = "warehouse0";
        String param = "think in Java";

        client(url,servername,param);
    }
}
