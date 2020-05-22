package practice;

/**
 * @author ：shujie
 * @date ：2020/03/08
 * @description: 链表向右移动K（旋转链表）
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 思路：
 * 先将链表闭合成环
 * 找到相应的位置断开这个环，确定新的链表头和链表尾
 * 新的链表头在哪里？在位置 n-k 处，其中 n 是链表中点的个数，新的链表尾就在头的前面，位于位置 n-k-1。
 * k 可以被写成 k = (k // n) * n + k % n 两者加和的形式，其中前面的部分不影响最终的结果，因此只需要考虑 k%n 的部分，这个值一定比 n 小。
 *
 *
 * 算法实现很直接：
 *
 * 找到旧的尾部并将其与链表头相连 old_tail.next = head，整个链表闭合成环，同时计算出链表的长度 n。
 * 找到新的尾部，第 (n - k % n - 1) 个节点 ，新的链表头是第 (n - k % n) 个节点。
 * 断开环 new_tail.next = None，并返回新的链表头 new_head。
 *
 */
public class rotateRight {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        // close the linked list into the ring
        ListNode oldTail = head;
        int n;
        for(n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // break the ring
        newTail.next = null;

        return newHead;
    }

}
