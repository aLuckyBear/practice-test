package other;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：shujie
 * @date ：2020/03/16
 * @description:
 */
public class HelloImpl implements Hello {

    @Override
    public void say(String str) {
        ReentrantLock lock = new ReentrantLock();
        lock.newCondition();
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);
        queue.put(1);



    }
}
