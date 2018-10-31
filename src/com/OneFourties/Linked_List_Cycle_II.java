package com.OneFourties;

import com.ListNode;

// LC 142. Linked List Cycle II
public class Linked_List_Cycle_II {
    //Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        //1. check if there is a cycle
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                //2. when determined there is a cycle, try to find the start
                ListNode slow2 = head;
                while(slow2!=slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
