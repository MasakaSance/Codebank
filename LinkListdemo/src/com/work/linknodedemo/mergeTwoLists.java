package com.work.linknodedemo;

public class mergeTwoLists {
    public static void main(String[] args) {

    }

    public ListNode mergetwolists(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        while (list1 != null && list2 != null){
            if (list1.val >= list2.val){
                result.next = list2;
                list2 = list2.next;
            }
            else{
                result.next = list1;
                list1 = list1.next;
            }
            result = result.next;
        }

        if(list1 != null) result.next = list1;
        if(list2 != null) result.next = list2;

        return dummy.next;

    }
}
