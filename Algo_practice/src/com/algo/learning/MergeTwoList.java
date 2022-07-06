package com.algo.learning;
//Leetcode 21
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class MergeTwoList {
    private ListNode add(int []input) {
        ListNode start = new ListNode();
        ListNode previous = start;
        for (int i=0;i<input.length;i++) {
            previous.next = new ListNode(input[i]);
            previous = previous.next;
        }
        return start.next;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start = new ListNode();
        ListNode temp = start;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return start.next;
    }

    public static void main(String[] args) {
        MergeTwoList mergeTwoList = new MergeTwoList();
        int input1 [] = {1,2,4};
        int input2[] = {1,3,4};
        ListNode list1 = mergeTwoList.add(input1);
        /*while (list1!= null) {
            System.out.print(list1.val+",");
            list1 = list1.next;
        }*/
        ListNode list2 = mergeTwoList.add(input2);
        /*System.out.println();
        while (list2 != null) {
            System.out.print(list2.val+",");
            list2 = list2.next;
        }*/
        System.out.println();
        ListNode listNode = mergeTwoList.mergeTwoLists(list1,list2);
        while (listNode != null) {
            System.out.print(listNode.val+",");
            listNode = listNode.next;
        }
    }
}
