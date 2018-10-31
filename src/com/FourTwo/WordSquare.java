package com.FourTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LC 425 Word Square
public class WordSquare {
    /*
    * I was trying to figure the time and space complexities of the solution:
    Parameters: n words with max k chars
    Time:

    Build trie -> O(nk)
    Loop through all words -> O(n)
    Check all prefix till the max chars -> k * (trie_prefix_ match) -> O(k^2).
    Each prefix can return n words and we will loop through them all till k length -> n * recursion.
    Total: O(nk + n(k^2 + n(k^2 + ...))
    Does this seem right and what would be the recurrence solution?

    Space:

    Build trie -> O(nk).
    We reuse ansBuilder so max will be -> O(k*nk) -> O(nk^2)
    Each prefix add an element from each word in ansBuilder -> O(k).
    Total: O(nk + n(k^2) + k) -> O(nk^2).
    * */
    //Approach 1: DFS + Trie (better)
    //1. implement Trie: store a list of words with the prefix on each trie node
    //1-a. trie node
    class TrieNode {
        List<String> startWith;
        TrieNode[] children;

        TrieNode() {
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }

    //1-b. trie
    class Trie {
        TrieNode root;
        //constructor
        Trie(String[] words) {
            root = new TrieNode();
            for (String w : words) {
                TrieNode cur = root;
                for (char ch : w.toCharArray()) {
                    int idx = ch - 'a';
                    if (cur.children[idx] == null)
                        cur.children[idx] = new TrieNode();
                    cur.children[idx].startWith.add(w);
                    cur = cur.children[idx];
                }
            }
        }

        List<String> findByPrefix(String prefix) {
            List<String> ans = new ArrayList<>();
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null)
                    return ans;
                cur = cur.children[idx];
            }
            ans.addAll(cur.startWith);
            return ans;
        }
    }

    public List<List<String>> wordSquares2(String[] words) {
        //create result set for return
        List<List<String>> ans = new ArrayList<>();
        //corner case
        if (words == null || words.length == 0)
            return ans;
        int len = words[0].length();
        //construct the trie
        Trie trie = new Trie(words);
        List<String> ansBuilder = new ArrayList<>();
        //use every word as a start
        for (String w : words) {
            ansBuilder.add(w);
            //DFS
            search(len, trie, ans, ansBuilder);
            //back tracking
            ansBuilder.remove(ansBuilder.size() - 1);
        }

        return ans;
    }

    private void search(int len, Trie tr, List<List<String>> ans,
                        List<String> ansBuilder) {
        if (ansBuilder.size() == len) {
            ans.add(new ArrayList<>(ansBuilder));
            return;
        }

        int idx = ansBuilder.size();
        StringBuilder prefixBuilder = new StringBuilder();
        for (String s : ansBuilder)
            prefixBuilder.append(s.charAt(idx));
        List<String> startWith = tr.findByPrefix(prefixBuilder.toString());
        for (String sw : startWith) {
            ansBuilder.add(sw);
            search(len, tr, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }
    }
    //Approach 2: DFS+Pruning + HashMap
    // I created a Character to List map that contains all words that starts with that character.
    // Then recurse through each character of the 1st word in the word square, get the list for that character,
    // and make sure the rest of the characters match.
    //HashMap-> key is a prefix, value is a list of words with that prefix
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> output = new ArrayList();
        Map<Character, List<String>> map = new HashMap();
        for(String word: words) {
            char c = word.charAt(0);
            map.computeIfAbsent(c,k->new ArrayList<String>()).add(word);
        }
        for(String word:words) {
            List<String> wordSquare = new ArrayList();
            wordSquare.add(word);
            helper(wordSquare, word, 1, output, map);
        }
        return output;
    }

    private void helper(List<String> ws, String s, int i, List<List<String>> output, Map<Character,List<String>> map) {
            if(i == s.length()) {
                output.add(new ArrayList<String>(ws));
                return;
            }
            List<String> words = map.get(s.charAt(i));
            if(words != null) {
                for(String w:words) {
                    boolean match = true;
                    for(int j = 1; j<=i-1; j++) {
                        if(w.charAt(j) != ws.get(j).charAt(i)) {
                            match = false;
                            break;
                        }
                    }
                    if(match) {
                        ws.add(w);
                        helper(ws,s,i+1, output, map);
                        ws.remove(ws.size()-1);
                    }
                }
            }
    }
}
