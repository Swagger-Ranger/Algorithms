/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: MultiThread_Create
 * Author:   liufei32@outlook.com
 * Date:     2018/10/20 23:28
 * Description: 多线程的创建
 * Aha-eureka:
 *******************************************************************************/

package JavaSE.MultiThread;

public class MultiThread_Create {

//    Runnable

    Runnable myRun = () -> {
        System.out.println("this is my myRun!");
    };

    Thread thread = new Thread(myRun);

    public static void main(String[] args) {
        MultiThread_Create m = new MultiThread_Create();
        m.thread.start();
    }

}
