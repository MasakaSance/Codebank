package com.work.linknodedemo;


public class removerNthFromEnd {
    public static void main(String[] args) {
        
    }
    
    public static ListNode removen(ListNode head, int n){
        ListNode current= new ListNode(0);
        current.next = head;

        //定义双指针 快指针先走n步
        ListNode fast = current;
        ListNode low = current;

        //快指针先移动n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //一起动
        while (fast.next != null){
            fast = fast.next;
            low = low.next;
        }

        low.next= low.next.next;

        
        
        return current.next;
    }
}
