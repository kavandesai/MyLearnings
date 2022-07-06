package com.algo.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
// Leetcode 23
public class MergeKLists {
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list = Arrays.stream(lists).collect(Collectors.toList());
        if (lists == null || lists.length == 0) {
            return null;
        }


        while (list.size() > 1) {
            List<ListNode> mergedList = new ArrayList<>();
            for(int i=0;i<list.size();i=i+2) {
                ListNode list1 = list.get(i);
                ListNode list2 = null;
                if (i + 1 < list.size()) {
                    list2 = list.get(i + 1);
                }
                mergedList.add(mergeTwoLists(list1,list2));
            }
            list = mergedList;

        }
        return list.get(0);

    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode temp = head;

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

        return head.next;
    }

    private ListNode add(int []input) {
        ListNode start = new ListNode();
        ListNode previous = start;
        for (int i=0;i<input.length;i++) {
            previous.next = new ListNode(input[i]);
            previous = previous.next;
        }
        return start.next;
    }

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();

        List<ListNode> lists = new ArrayList<>();
        int [] input1 = {1,4,5};
        int [] input2 = {1,3,4};
        int [] input3 = {2,6};

        lists.add(mergeKLists.add(input1));
        lists.add(mergeKLists.add(input2));
        lists.add(mergeKLists.add(input3));
        ListNode merged = mergeKLists.mergeKLists(lists.toArray(new ListNode[lists.size()]));
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }

    }
}
