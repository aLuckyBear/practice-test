package practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：shujie
 * @date ：2020/03/07
 * @description: 顺序打印ABC
 */
public class TestABC {
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    private static int count = 0;

    static class ThreadA implements Runnable {

        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 0) {
                        // 阻塞当前线程，并释放锁
                        A.await();
                    }
                    System.out.print("A");
                    count++;
                    B.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadB implements Runnable {

        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 1) {
                        // 阻塞当前线程，并释放锁
                        B.await();
                    }
                    System.out.print("B");
                    count++;
                    C.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadC implements Runnable {

        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 2) {
                        // 阻塞当前线程，并释放锁
                        C.await();
                    }
                    System.out.println("C");
                    count++;
                    A.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
        Thread threadC = new Thread(new ThreadC());
        threadC.start();
        threadC.join();
    }

}
