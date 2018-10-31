package com.TwoHundred;


//LC 208
public class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode (char c) {
        //TrieNode node = new TrieNode();
        this.val = c;
    }
}
