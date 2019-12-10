package practice;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;

/**
 * @author ：shujie
 * @date ：2019/12/09
 * @description: LRU算法(单链表)
 * 维护一个有序单链表，越靠近链表尾部的结点是越早被访问的。当有一个新的数据被访问时，从头开始遍历链表。
 * 1. 访问数据：
 *      1.1 若数据存在，遍历得到该结点，并将其从原来位置删除，然后插入到链表头部
 * 1.2 若数据不存在
 *      1.2.1 若缓存未满，直接将该结点插入头部
 *      1.2.2 若缓存已满，将尾结点删除，新结点插入头部
 */
public class LRUCacheSingle {

    LinkedListNew list = new LinkedListNew();

    int maxSize = 10;

    public void LRUCacheSingle(int maxSize) {
        this.maxSize = maxSize;
    }

    public String get(String data) {
        String result = list.getNode(data);

        // 查询到，删除，并移动到链表头
        if (!StringUtils.isBlank(result)) {
            list.removeNode(data);
            list.addFirst(data);
            return result;
        }

        // 未查询到
        if (list.size >= maxSize) {
            // 缓存已满
            list.removeLast();
            list.addFirst(data);
        } else {
            list.addFirst(data);
        }
        return result;
    }

    public void put(String data) {
        
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

    }


}
