package com.OneTwo;
//127. Word Ladder

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    /*
    * Word Ladder
    Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end,
    such that:
    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
    For example,
    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    * */
    //这道题是经典的广度有优先搜索的例子，也是Dijkstra's algorithm的变形-> BFSII

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList); //create wordSet to check
        Set<String> visited = new HashSet(); //create a set/queue to track visited node
        visited.add(beginWord); //init queue for BFS
        int dist = 1;
        while(!visited.contains(endWord)) { //while not found yet, move on
            Set<String> temp = new HashSet();
            for(String word : visited) { //go through each node in this level
                for(int i = 0; i<word.length(); i++) { //change each letter in this node
                    char[] chars = word.toCharArray();
                    for(int j = (int)'a'; j<=(int)'z'; j++) { //replace with [a->z]
                        chars[i] = (char)j; //remember to convert type
                        String newWord = new String(chars); //construct new words
                        if(wordSet.contains(newWord)) {
                            temp.add(newWord);
                            wordSet.remove(newWord);//each word can only use once->prevent cycle
                        }
                    }
                }
            }
            dist += 1; //finish current level count +1
            if(temp.size() == 0) { //must use temp.size() == 0 but not temp == null, because temp has already been initialized
                return 0;
            }
            visited = temp; //add in new nodes from current level
        }
        return dist;
    }
}
