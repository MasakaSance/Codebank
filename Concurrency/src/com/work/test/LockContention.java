package com.work.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockContention {
    public static void main(String[] args) {
        // 创建一个共享对象
        SharedResource resource = new SharedResource();

        // 创建线程1
        Thread thread1 = new Thread(() -> {
            resource.lock();
            try {
                System.out.println("Thread 1 acquired the lock.");
                try {
                    Thread.sleep(5000); // 模拟线程1持有锁5秒
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // 恢复中断状态
                    System.err.println("Thread 1 was interrupted.");
                }
                System.out.println("Thread 1 released the lock.");
            } finally {
                resource.unlock();
            }
        }, "Thread-1");

        // 创建线程2
        Thread thread2 = new Thread(() -> {
            resource.lock();
            try {
                System.out.println("Thread 2 acquired the lock.");
            } finally {
                resource.unlock();
            }
        }, "Thread-2");

        // 启动线程
        thread1.start();
        thread2.start();
    }

    static class SharedResource {
        private final Lock lock = new ReentrantLock();

        public void lock() {
            lock.lock();
        }

        public void unlock() {
            lock.unlock();
        }
    }
}
