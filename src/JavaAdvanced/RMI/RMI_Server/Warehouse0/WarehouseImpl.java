package JavaAdvanced.RMI.RMI_Server.Warehouse0;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: WarehouseImpl
 * @Author: liufei32@outlook.com
 * @Date: 2019/5/11 22:56
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {

    private Map<String, Double> prices;

    public WarehouseImpl() throws RemoteException {

        super();
        //物品列表
        prices = new HashMap<>();
        prices.put("the book of RMI_Java", 99.9);
        prices.put("think in Java", 99.8);

    }

    @Override
    public double getPrice( String param ) throws RemoteException {
        Double price = prices.get(param);
        return price == null ? 0 : price;
    }
}
