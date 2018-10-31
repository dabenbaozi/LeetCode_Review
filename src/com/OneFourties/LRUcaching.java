package com.OneFourties;

import com.CacheNode;

import java.util.HashMap;
import java.util.Map;

public class LRUcaching {
        Map<Integer, CacheNode> map;
        int capacity;
        //head.next & tail.next 表示真实的head&tail；
        //包起来防止null
        CacheNode head = new CacheNode(-1,-1);
        CacheNode tail = new CacheNode(-1,-1);

        //constructor
        public LRUcaching(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
        }

        //helper method to move most recently used/created node to the tail
        private void moveToTail(CacheNode target, boolean isNew) {
            //move only if node is not at tail already
            if(target != tail.next) {
                //most recently used
                if(!isNew) {
                    //change the old node's pointer
                    target.pre.next = target.next;
                    target.next.pre = target.pre;
                }
                //most recently created
                tail.next.next = target;
                target.pre = tail.next;
                tail.next = target;
            }
            //else stay status quo
        }

        //if find target node,  return value and move to tail
        // else returen -1 as not found
        public int get(int key) {
            if(map.containsKey(key)) {
                CacheNode target = map.get(key);
                //move the existing node to the tail
                moveToTail(target,false);
                //remember to update the target.next to prevent circle
                tail.next.next = null;
                return target.value;
            }
            return -1;
        }

        public void set(int key, int value) {
            //if current node already exists in cache
            if(map.containsKey(key)) {
                CacheNode target = map.get(key);
                target.value = value;
                map.put(key,target);
                //move the recently used node to tail
                moveToTail(target, false);
                //cache is not-full, just add to the tail
            } else if(map.size() < capacity) {
                CacheNode newNode = new CacheNode(key, value);
                map.put(key, newNode);
                if(head.next == null) {
                    head.next = newNode;
                    newNode.pre = head;
                    tail.next = newNode;
                } else {
                    //move the newly created node to the tail
                    moveToTail(newNode, true);
                }
                //cache is full, delete the node from head and add new Node to the tail
            } else {
                CacheNode newNode = new CacheNode(key, value);
                map.remove(head.next.key);
                map.put(key, newNode);
                //cache only has one node
                if(head.next == tail.next) {
                    head.next = newNode;
                    tail.next = newNode;
                } else {//more than one node in the cache, delete from head
                    head.next.next.pre = head; //update newhead.pre = head
                    head.next = head.next.next;//update head;
                    //move the newly created node to the tail
                    moveToTail(newNode, true);
                }



            }
        }



}