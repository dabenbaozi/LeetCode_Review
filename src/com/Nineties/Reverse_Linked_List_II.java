package com.Nineties;

import com.ListNode;

import static com.PrintFunctions.printLinkedList;

//LC 92. Reverse Linked List II
public class Reverse_Linked_List_II {

    /*
    * Reverse a linked list from position m to n. Do it in one-pass.
    * Note: 1 ≤ m ≤ n ≤ length of list.
    * */
    //one-pass.
    public static void main(String[] args) {
        int m = 2, n = 4;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printLinkedList(node1);
        System.out.println("");
        printLinkedList(reverseBetween(node1,m,n));
    }

    //Simply just reverse the list along the way using 4 pointers: dummy, pre, start, then
    //Iterative
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //corner case
        if(head == null) {
            return null;
        }
        //use dummyHead to mark the head of list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //use pre as a pointer to the node before reverse
        ListNode pre = dummy;
        for(int i = 0; i<m-1; i++) {
            pre = pre.next;
        }
        //a pointer to beginning of a sub-list that will be reversed
        ListNode start = pre.next;
        // a pointer to a node that will be reversed
        ListNode then = start.next;
        for(int i = 0; i<n-m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
            System.out.println("list during trans");
            printLinkedList(dummy.next);
            System.out.println("");
        }
        return dummy.next;
    }

}
