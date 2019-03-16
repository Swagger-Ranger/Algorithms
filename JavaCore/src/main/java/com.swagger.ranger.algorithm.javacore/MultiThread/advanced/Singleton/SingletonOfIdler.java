package JavaCore.MultiThread.advanced.Singleton;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: SingletonOfIdler
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/5 14:26
 * @Description: 懒汉式单例模式
 * @Aha-eureka:  懒汉式单例模式存在线程安全性问题，因为实例化并不是原子性操作
 *******************************************************************************/

public class SingletonOfIdler {

    private SingletonOfIdler() { }

    private static volatile SingletonOfIdler instance;


    //不加线程安全的操作
    /*public static SingletonOfIdler getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingletonOfIdler();
        }

        return instance;
    }*/

    //不考虑性能的线程安全的操作，直接使用synchronized 修饰符
    /*public static synchronized SingletonOfIdler getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingletonOfIdler();
        }

        return instance;
    }*/

    /**
     * 考虑性能和线程安全性的更好的实现
     * 对块加锁，这样可以避免每次都要去获取锁，因为这个单例中只有实例化时会出现安全性操作
     * 同时对私有变量instance 加volatile修饰符，避免因为jvm优化中指令重排序（即虚机对代码进行优化，
     * 可能后面的代码先于前面的代码执行）而导致在双重检验加锁中出现检验出错而导致线程安全问题
     * 双重检验加锁
     * @return
     */
    public static SingletonOfIdler getInstance() {

        if (instance == null) {
            synchronized (SingletonOfIdler.class) {
                //双重检验加锁
                if (instance == null) {
                    instance = new SingletonOfIdler();
                }
            }
        }

        return instance;
    }

    public static void main( String[] args ) {
        //下面打印都是相同的hash值，但并不代表就没有线程安全性问题
        /**
         * 在MultiThreadTestOfSingleton.java的测试中结果如下
         * pool-1-thread-1:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6c526acc
         * pool-1-thread-2:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6a1ebbc--->这里就出现了线程安全性问题
         * pool-1-thread-2:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6c526acc
         * pool-1-thread-1:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6c526acc
         * pool-1-thread-2:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6c526acc
         * pool-1-thread-1:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6c526acc
         * pool-1-thread-2:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6c526acc
         */
        SingletonOfIdler s1 = SingletonOfIdler.getInstance();
        SingletonOfIdler s2 = SingletonOfIdler.getInstance();
        SingletonOfIdler s3 = SingletonOfIdler.getInstance();
        SingletonOfIdler s4 = SingletonOfIdler.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
