package practice.lru;

/**
 * @author ：shujie
 * @date ：2019/12/09
 * @description: 单链表实现
 */
public class LinkedListNew {

    Node first;
    int size;

    public LinkedListNew() {

    }

    public void addFirst(String data) {
        Node node = new Node(data);
        if (first == null) {
            first = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;

    }

    public void addLast(String data) {
        Node node = new Node(data);
        if (first == null) {
            first = node;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    public void removeLast() {
        if (size == 0) {
            return;
        }

        if (size == 1) {
            first = null;
            size--;
            return;
        }

        Node temp = first;
        Node tempNext = temp.next;

        while (tempNext.next != null) {
            temp = tempNext;
            tempNext = tempNext.next;
        }

        temp.next = null;
        size--;
    }

    public boolean removeNode(String data) {
        if (size == 0) {
            return false;
        }

        Node temp = first;
        Node pre = first;
        while (!temp.data.equals(data)) {
            if (temp.next == null) {
                return false;
            }

            pre = temp;
            temp = temp.next;
        }

        if (temp == first) {
            first = temp.next;
            size--;
        } else {
            pre.next = temp.next;
            size--;
        }
        return true;
    }

    public String getNode(String data) {
        if (first == null) {
            return null;
        }

        Node temp = first;
        while(!temp.data.equals(data)) {
            temp = temp.next;
            if (temp == null) {
                return null;
            }
        }

        return temp.data;
    }

    public String getLinkedList() {
        StringBuilder sb = new StringBuilder();
        if (first.next == null) {
            sb.append(first.data);
        } else {
            Node temp = first;
            while (temp.next != null) {
                sb.append(temp.data + "->");
                temp = temp.next;
            }
            sb.append(temp.data);
        }
        return sb.toString();
    }

    class Node {
        Node next;
        String data;

        public Node(String data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedListNew list = new LinkedListNew();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.addLast("6");
        list.addLast("7");
        list.addLast("8");

        System.out.println("list = " + list.getLinkedList());
        list.removeLast();
        System.out.println("list = " + list.getLinkedList());
        list.removeNode("3");
        System.out.println("list = " + list.getLinkedList());


    }

}

