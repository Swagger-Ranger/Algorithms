package JavaSE.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: InetAddressDemo
 * Author:   liufei32@outlook.com
 * Date:     2018/11/13 22:02
 * Description: socket IP address
 * Aha-eureka:
 *******************************************************************************/

//InetAddress没有构造方法
public class InetAddressDemo {
    //获得InetAddress实例
    public static void getAddress() throws UnknownHostException {
        //获取本机实例
        InetAddress address = InetAddress.getLocalHost();
        String hostName = address.getHostName();
        String hostAddress = address.getHostAddress();
        byte[] bytesAddress = address.getAddress();
        System.out.println("this is my localHost: "+ hostName+" and that is my IP address: " +hostAddress+" " +
                Arrays.toString(bytesAddress));
        //获取其它实例
        InetAddress address1 = InetAddress.getByName("other hostName");
        InetAddress address2 = InetAddress.getByName("IP address");

    }

    public static void main( String[] args ) throws UnknownHostException {
        getAddress();
    }
}
