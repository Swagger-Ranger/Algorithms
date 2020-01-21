package JavaAdvanced.RMI.RMI_Server.Warehouse0;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Server
 * @Author: liufei32@outlook.com
 * @Date: 2019/5/11 23:04
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class Server {

    public static void server( String URL, int port ) throws RemoteException, MalformedURLException {

        System.out.println("-----------server----------");
        Warehouse centralWarehouse = new WarehouseImpl();

        //将服务器对象绑定8001端口，对外提供服务
        LocateRegistry.createRegistry(port);
        Naming.rebind(URL, centralWarehouse);

        System.out.println("---waiting for call---------");
    }

    public static void main( String[] args ) throws MalformedURLException, RemoteException {
        String URL = "rmi://127.0.0.1:8001/warehouse0";
        int port = 8001;
        server(URL, port);
    }
}
