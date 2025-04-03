package com.work.linknodedemo;

public class deleteDuplicates {
    public static void main(String[] args) {

    }

    public static ListNode deleteduplicates(ListNode head){
        if (head == null) return head;
        if (head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        current.next = head;

        ListNode node1 = current.next;
        ListNode node2 = current.next;
        int a = 0;

        while (node2 != null){
            node2 = node2.next;
            if (node2 != null && node1.val == node2.val){
                node2 = node2.next;
                a++;
            }
            if (node2 != null && node1.val != node2.val){
                if (a == 0){
                    current.next = node1;
                    current = current.next;
                    node1 = node1.next;
                }

                if (a > 0){
                    node1 = node2;
                    current.next = node1;
                    a =0;
                }
            }
        }
        if (a>0) current.next = null;
        return dummy.next;
    }
}
