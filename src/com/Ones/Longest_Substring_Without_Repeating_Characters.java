package com.Ones;


//LC 3. Longest Substring Without Repeating Characters
public class Longest_Substring_Without_Repeating_Characters {
    //Given a string, find the length of the longest substring without repeating characters.
    public static void main(String[] args) {
        System.out.println("TC1:");
        String s = "abcabcbb"; //expected 3

        System.out.println("TC2:");
        String s2 = "bbbbb"; //expected 1

        System.out.println("TC3:");
        String s3 = "pwwkew"; //expected 3

    }


//    public int lengthOfLongestSubstring(String s) {
//        HashSet<Character> set = new HashSet();
//        int slow = 0, fast = slow;
//        int res = 0;
//        if(s == null || s.length() <= 0) {
//            return 0;
//        } else if(s.length() <= 1) {
//            return 1;
//        }
//        while(fast < s.length()) {
//
//
//        }
//
//    }

}
