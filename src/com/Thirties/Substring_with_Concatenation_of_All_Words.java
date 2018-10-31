package com.Thirties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static com.PrintFunctions.printList;

//LC 30 Substring with Concatenation of All Words
public class Substring_with_Concatenation_of_All_Words {

    /*
    * You are given a string, s, and a list of words, words,
    * that are all of the same length. Find all starting indices of substring(s)
    * in s that is a concatenation of each word in words exactly once and
    * without any intervening characters.
    *
    * */

    //Sliding window
    //1. same length!! 可以直接从s中截取固定大小的子串判读是否在words中出现
    //2. 用一个临时的字典来纪录每次匹配出现的word的数量，通过与words中每个单词出现的数量做对比


    public static void main(String[] args) {
        //TC1
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        //expected output [0,9]
        List<Integer> list = findSubstring(s,words);
        printList(list);
        //TC2
        String s2 = "wordgoodstudentgoodword";
        String[] words2 = new String[]{"word", "student"};
        //expected output []
        List<Integer> list2 = findSubstring(s2,words2);
        System.out.println("here");
        printList(list2);
    }

    //Time = O(n)
    //Space = O(m*l)-> m = number of words
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList();
        //corner case
        if(s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        //process
        //1. pre get values
        int wordLength = words[0].length(); //get length of each word, all word has same length
        HashMap<String, Integer> map = new HashMap(); //hashmap to count each word
        for(int i = 0; i<words.length;i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        //2.
        for(int i = 0; i<wordLength; i++) {
            HashMap<String, Integer> curMap = new HashMap();
            int count = 0, left = i;
            for(int j = i; j<=s.length()-wordLength; j+=wordLength) {
                String str = s.substring(j,j+wordLength);
                if(map.containsKey(str)) {
                    curMap.put(str,curMap.getOrDefault(str,0)+1);
                    if(curMap.get(str) <= map.get(str)) {
                        count++;
                    } else {
                        while(curMap.get(str) > map.get(str)) {
                            String temp = s.substring(left, left+wordLength);
                            if(curMap.containsKey(temp)) {
                                curMap.put(temp, curMap.get(temp)-1);
                                if(curMap.get(temp) <map.get(temp)) {
                                    count--;
                                }
                            }
                            left += wordLength;
                        }
                    }
                    if(count == words.length) {
                        result.add(left);
                        //if (left <)
                        String temp = s.substring(left, left+wordLength);
                        if(curMap.containsKey(temp)) {
                            curMap.put(temp,curMap.get(temp)-1);
                        }
                        count--;
                        left+=wordLength;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    left = j+wordLength;
                }

            }

        }
        return result;
    }
}
