package JavaCore.MultiThread.advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadPool
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/4 15:47
 * @Description: 线程池的入门
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadPool {

    /**
     * 线程池具体的有固定大小的newFixedThreadPool，newCachedThreadPool()则是根据任务数量来自动管理线程池大小，线程池中线程不够用来就会自动新建
     */
    public static void threadPoolOfExcutor() {
        //Executor和ExecutorService都是一个接口，Executors.new...有很多可用的线程池类型可用
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            //excute中创建线程
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" is running...");
                }
            });
        }
        //销毁线程池
        threadPool.shutdown();
    }

    public static void main( String[] args ) {
        threadPoolOfExcutor();
    }
}
