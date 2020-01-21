package JavaAdvanced.RMI.RMI_Server.Warehouse0;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Warehouse
 * @Author: liufei32@outlook.com
 * @Date: 2019/5/11 22:46
 * @Description: RMI要调用的类
 * @Aha-eureka:
 *******************************************************************************/

public interface Warehouse extends Remote {
    double getPrice( String param ) throws RemoteException;
}
