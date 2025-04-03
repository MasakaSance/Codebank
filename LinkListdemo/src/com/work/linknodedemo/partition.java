package com.work.linknodedemo;

public class partition {
    public static void main(String[] args) {

    }

    public static ListNode partition(ListNode head, int x){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        current.next = head;

        if (head == null) return head;
        if (head.next == null) return head;

        ListNode a = new ListNode(0); //比x small
        ListNode b = new ListNode(0);//比x big
        ListNode ahead = a;
        ListNode bhead = b;

        //循环历遍head里面的数
        current = current.next;
        while (current != null){
            if (current.val < x){
                ahead.next = current;
                ahead = ahead.next;
                current = current.next;
            }

            if (current.val >= x){
                bhead.next = current;
                bhead = bhead.next;
                current = current.next;
            }
        }

        bhead.next = null;
        ahead.next = b.next;

        return a.next;

    }
}
