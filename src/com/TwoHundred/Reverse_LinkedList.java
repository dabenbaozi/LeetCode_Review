package com.TwoHundred;

import com.ListNode;

import static com.PrintFunctions.printLinkedList;

//LC 206. Reverse Linked List
public class Reverse_LinkedList {
    //Reverse a singly linked list.

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printLinkedList(reverseList(node1));
        System.out.println("");
        printLinkedList(reverseList2(reverseList(node5)));

    }


    //Sol 1: iteratively
    public static ListNode reverseList(ListNode head) {
        //corner case
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        //process
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;

    }


    //Sol 2: recursively
    public static ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
