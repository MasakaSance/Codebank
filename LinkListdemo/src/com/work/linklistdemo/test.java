package com.work.linklistdemo;

public class test {
    public static void main(String[] args) {
        //创建两个ListNode对象
        ListNode l1 = new ListNode(2);//这个链表的头结点是2
        l1.next = new ListNode(4);//2的下一个结点是4
        l1.next.next = new ListNode(3);//

        ListNode l2 = new ListNode(5);//这个链表的头结点是5
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        //342+465=807 逆序输出 7 0 8

        test test1 = new test();
        ListNode result = test1.addTwoNumbers(l1, l2);
//        int[] a = convertToListArray(result);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode visualhead = new ListNode(0);
        ListNode current = visualhead;

        int carry = 0;
        while (l1 != null || l2 != null){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            int sum1 = sum%10;
            carry = sum/10;

            current.next = new ListNode(sum1);
            current = current.next;

            if (l1 != null){
                l1 = l1.next;
            }

            if (l2 != null){
                l2 = l2.next;
            }
        }

        if (carry>0){
            current.next = new ListNode(carry);
        }

        return visualhead.next;

    }
}
