package com.work.linklistdemo;

public class test1 {
    public static void main(String[] args) {

    }
    public static ListNode adda(ListNode l1,ListNode l2){
        //0
        ListNode vhead =new ListNode(0);
        ListNode current = vhead;
        int carry = 0;
        //1
        while (l1 != null && l2 != null){
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;
            //!!!!
            int sum = a + b+ carry;

            //2
            carry = sum/10;

            //3
            current.next = new ListNode(sum%10);
            //!!!
            current = current.next;

            //4
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) current.next = new ListNode(carry);

        return vhead.next;
    }
    // 虚拟头节点，方便处理边界情况
    // 遍历两个链表直到两者都为空
    // 更新进位值
    // 创建新节点并连接到结果链表
    // 移动到下一个节点
    // 如果最后还有进位，添加一个新节点
    // 返回结果链表，跳过虚拟头节点
}
