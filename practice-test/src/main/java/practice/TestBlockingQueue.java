package practice;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：shujie
 * @date ：2020/03/07
 * @description: 实现阻塞队列
 */
public class TestBlockingQueue {

    private static Lock lock = new ReentrantLock();
    private static Condition notFull = lock.newCondition();
    private static Condition notEmpty = lock.newCondition();
    private static LinkedList<Object> list = new LinkedList<Object>();
    private static int capacity;
    private static int count;

    public void put(Object o) {
        try {
            lock.lock();
            if (capacity == list.size()) {
                notFull.await();
            }
            list.add(o);
            count++;
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        try {
            lock.lock();
            if (capacity == 0) {
                notEmpty.await();
            }
            list.removeFirst();
            count--;
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestBlockingQueue m = new TestBlockingQueue();

    }

}
