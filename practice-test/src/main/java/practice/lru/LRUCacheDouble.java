package practice.lru;


/**
 * 题目
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据
 * get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据
 * put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：shujie
 * @date ：2019/12/17
 * @description: LRU算法（双向链表 + map）
 * get(key): 通过hashMap找到LRU链表节点，将节点插入到链表头部，然后返回缓存值
 * put(key, value): map上找到对应节点，如果存在，则更新节点值，并把节点移动到链表头部。
 * 如果不存在，构造新的节点，并尝试将其塞入到链表头部，如果LRU空间不足，则通过tail淘汰掉队尾节点，同时在map中移除掉对应的key
 */
public class LRUCacheDouble {

    /**
     * 当前缓存大小
     */
    private int count;

    /**
     * 最大容量
     */
    private int capacity;

    private Node head;

    private Node tail;

    private Map<Integer, Node> map;

    public LRUCacheDouble(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>(capacity * 2);

        head = new Node();
        head.pre = null;

        tail = new Node();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    private static class Node {
        int key;
        int value;
        Node pre;
        Node post;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            this.moveToHead(node);
            return;
        }

        node = new Node();
        node.key = key;
        node.value = value;

        // LRU未满，直接移到头部
        if (count < capacity) {
            this.moveToHead(node);
            count ++;
            return;
        }

        // 已满，删除尾结点,node移到头部
        Node lastNode = this.popTail();
        map.remove(lastNode.key);

        this.moveToHead(node);
    }

    private Node popTail() {
        Node lastNode = tail.pre;
        this.removeNode(lastNode);
        return lastNode;
    }

    private void moveToHead(Node node) {
        this.removeNode(node);
        this.addHead(node);
    }

    private void removeNode(Node node) {
        Node preNode = node.pre;
        Node postNode = node.post;
        preNode.post = postNode;
        postNode.pre = preNode;
    }

    private void addHead(Node node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

}
