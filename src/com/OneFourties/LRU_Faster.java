package com.OneFourties;

import java.util.HashMap;
import java.util.Map;
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRU_Faster {
        //Doubly Linked List Nodes
        class Node {
            Node prev, next;
            int key, value;
            //constructor
            public Node (int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        //map<NodeValue, Node>
        private Map<Integer, Node> map;
        private int capacity;
        private Node tail, head;

        public LRU_Faster(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            this.tail.prev = head;
            this.head.next = tail;
        }

        public int get(int key) {
            //if not found, return -1
            if (!map.containsKey(key)) {
                return -1;
            }
            //if found, return value & move the used node to tail
            Node cur = map.get(key);
            //a.remove node
            delete_node(cur);
            //b.insert to tail
            move_to_tail(cur);
            return cur.value;
        }

        public void put(int key, int value) {
            //if already exists->update node value and move to the tail
            if(map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                delete_node(node);
                move_to_tail(node);
                //if not exists->create new node and save to the map
                //check memory space
                // -> if full ->delete from tail and add to tail
                // -> if not full -> add to tail directly
            } else {
                Node node = new Node(key, value);
                map.put(key,node);
                if(map.size() <= this.capacity) {
                    move_to_tail(node);
                } else {
                    //Overfitting
                    map.remove(head.next.key);
                    delete_node(head.next);
                    move_to_tail(node);
                }
            }
        }

        private void delete_node(Node cur) {
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
        }

        private void move_to_tail(Node cur) {
            cur.prev = tail.prev;
            tail.prev = cur;
            cur.prev.next = cur;
            cur.next = tail;
        }
    }



