package com.work.linknodedemo;

public class swapPairs {
    public static void main(String[] args) {

    }

    public static ListNode swappairs(ListNode head){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        current.next = head;


        if (current.next == null || current.next.next == null) return head;

        while (current.next != null && current.next.next != null){
            ListNode node1 = current.next;
            ListNode node2 = current.next.next;

            current.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            current = current.next.next;
        }

        return dummy.next;
    }
}
