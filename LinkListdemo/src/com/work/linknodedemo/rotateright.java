package com.work.linknodedemo;

public class rotateright {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                        new ListNode(4,
                                new ListNode(5)))));
        ListNode l2 = rotateright1(l1,2);
        while (l2 != null){
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }

    public static ListNode rotateright1(ListNode head,int k){
        ListNode dummy = new ListNode(0);
        ListNode currrent = dummy;
        currrent.next = head;

        if (currrent.next == null) return dummy.next;
        if (currrent.next.next == null) return dummy.next;

        //计算链表长度 找到尾节点
        int n = 1;
        ListNode tail = currrent.next;
        while (tail.next != null){
            n++;
            tail = tail.next;
        }
        System.out.println(n);

        //计算实际需要移动的步数
        if (k % n == 0) return dummy.next;
        if (k > n) k = k%n;

        //断开链表 并返回新的头节点
        ListNode node1 = currrent.next;
        ListNode node2 = currrent.next;
        for (int i = 0; i < n-k-1; i++) {
            node2 = node2.next;
            System.out.println(node2.val);
        }

        currrent.next = node2.next;
        node2.next = null;
        tail.next = node1;

        return dummy.next;
    }
}
