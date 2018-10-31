package com.OneFourties;

import com.ListNode;

//LC 141. Linked List Cycle
public class Cycle_in_linkedlist {
    /*
    Given a linked list, determine if it has a cycle in it.

    Follow up:
    Can you solve it without using extra space?
    */
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}
