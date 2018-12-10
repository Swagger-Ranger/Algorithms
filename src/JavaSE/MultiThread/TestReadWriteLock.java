package JavaSE.MultiThread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: TestReadWriteLock
 * Author:   liufei32@outlook.com
 * Date:     2018/11/12 23:57
 * Description: 线程读写锁
 * Aha-eureka:
 *******************************************************************************/

public class TestReadWriteLock {
    public static void main(String[] args){
        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        // 一个线程进行写
        new Thread(new Runnable(){
            public void run(){
                rw.set((int)(Math.random()*100));
            }
        },"Write:").start();

        // 100个线程进行读操作
        for(int i=0; i<100; i++){
            new Thread(new Runnable(){
                public void run(){
                    rw.get();
                }
            },"Read:").start();
        }
    }

}

class ReadWriteLockDemo{
    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();



    // 读
    public void get(){
        lock.readLock().lock(); // 上锁

        try{
            System.out.println(Thread.currentThread().getName()+":"+number);
        }finally{
            lock.readLock().unlock(); // 释放锁
        }
    }

    // 写
    public void set(int number){

        lock.writeLock().lock();

        try{
            System.out.println(Thread.currentThread().getName());

            this.number = number;
        }finally{
            lock.writeLock().unlock();
        }
    }
}
