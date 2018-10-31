package com;

//缓存节点，用于doublylinked list
public class CacheNode {
    public int key, value;
    public CacheNode pre, next;
    //constructor
    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.pre = null;
        this.next = null;
    }

}
