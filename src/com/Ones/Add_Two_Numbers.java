package com.Ones;

import com.ListNode;

import static com.PrintFunctions.printLinkedList;

//LC 2. Add Two Numbers
public class Add_Two_Numbers {

    /*
    * You are given two non-empty linked lists representing two non-negative integers.
    * The digits are stored in reverse order and each of their nodes contain a single digit.
    * Add the two numbers and return it as a linked list.
    * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    * */


    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);
        System.out.println("before:");
        System.out.println();
        printLinkedList(list1);
        System.out.println();
        printLinkedList(list2);
        System.out.println();
        System.out.println("after:");
        System.out.println();
        printLinkedList(addTwoNumbers(list1,list2));

    }

    //Time = O(n+n)=>O(n)->traverse list1 & list2
    //Space = O(n)->new list

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carrier = 0;
        while(l1 != null || l2 != null) {
            int x = l1!=null?l1.val:0;
            int y = l2!=null?l2.val:0;
            int val = x+y+carrier;
            carrier = 0;
            while(val >= 10) {
                val = val%10;
                carrier++;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carrier != 0) {
            cur.next = new ListNode(carrier);
        }
        return dummyHead.next;


    }
}
