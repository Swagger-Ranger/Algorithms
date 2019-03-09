package JavaCore.MultiThread.advanced.Lock;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: MyLock
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/8 12:53
 * @Description: 使用synchronized关键字来实现Lock接口，一个自定义的锁
 * @Aha-eureka:  实现一个可重入的锁
 *******************************************************************************/

public class MyLockReenter implements Lock {

    private boolean isLocked = false;

    Thread lockBy = null;

    int lockCount = 0;

    @Override
    public synchronized void lock() {

        Thread cunrrent = Thread.currentThread();

        while (isLocked && cunrrent!=lockBy) {
            try {
                wait();//进入等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isLocked = true;
        lockBy = cunrrent;
        lockCount++;
    }

    @Override
    public synchronized void unlock() {

        if (lockBy == Thread.currentThread()) {
            lockCount--;

            if (lockCount == 0) {
                notify();//唤醒其他线程
                isLocked = false;
            }
        }
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock( long time, @NotNull TimeUnit unit ) throws InterruptedException {
        return false;
    }

    @NotNull
    @Override
    public Condition newCondition() {
        return null;
    }
}
