package com.work.linklistdemo;

import java.util.ArrayList;
import java.util.List;

public class linktest1 {


    public static void main(String[] args) {
        //创建两个ListNode对象
        ListNode l1 = new ListNode(2);//这个链表的头结点是2
        l1.next = new ListNode(4);//2的下一个结点是4
        l1.next.next = new ListNode(3);//

        ListNode l2 = new ListNode(9);//这个链表的头结点是5
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        linktest1 linktest11 = new linktest1();
        ListNode result = linktest11.addTwoNumbers(l1, l2);
//        int[] a = convertToListArray(result);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

/// 将链表转换为数组
//    public static int[] convertToListArray(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//
//        // 遍历链表并将值添加到列表中
//        ListNode current = head;
//        while (current != null) {
//            list.add(current.val);
//            current = current.next;
//        }
//
//        // 将列表转换为数组
//        int[] array = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            array[i] = list.get(i);
//        }
//
//        return array;
//    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 虚拟头节点，方便处理边界情况
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // 遍历两个链表直到两者都为空
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            // 更新进位值
            carry = sum / 10;
            // 创建新节点并连接到结果链表
            current.next = new ListNode(sum % 10);
            current = current.next;

            // 移动到下一个节点
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 如果最后还有进位，添加一个新节点
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // 返回结果链表，跳过虚拟头节点
        return dummyHead.next;
    }
}
