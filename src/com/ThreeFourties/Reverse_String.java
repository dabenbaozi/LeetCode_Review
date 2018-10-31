package com.ThreeFourties;

//LC 344. Reverse String
public class Reverse_String {

     /*
     * Write a function that takes a string as input and returns the string reversed.
     * */

     public static String reverseString(String s) {
         char[] array = s.toCharArray();
         int left = 0, right = s.length()-1;
         while(left < right) {
             swap(array,left++, right--);
         }
         return new String(array);
     }

     private static void swap(char[] array, int left,int right) {
         char temp = array[left];
         array[left] = array[right];
         array[right] = temp;
     }
}

