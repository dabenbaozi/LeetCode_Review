package com;

import java.util.List;

public class PrintFunctions {

    public static void printList(List<Integer> words) {
        if(words == null || words.size() <= 0) {
            System.out.println("it is an empty list");
        }
        for(Integer i: words) {
            System.out.println("i:  "+ i);

        }

    }

    public static void printArray(int[] words) {
        if(words == null || words.length <= 0) {
            System.out.println("it is an empty list");
        }
        for(Integer i: words) {
            System.out.println("i:  "+ i);

        }

    }

    public static void printListString(List<String> words) {
        if(words == null || words.size() <= 0) {
            System.out.println("it is an empty list");
        }
        for(String i: words) {
            System.out.println("i:  "+ i);

        }

    }

    public static void printLinkedList(ListNode l1) {
        if(l1 == null) {
            System.out.println("it is an empty list");
        }
        System.out.print(l1.val+"->");
        while(l1.next != null) {
            l1 = l1.next;
            System.out.print(l1.val+"->");

        }

    }

}
