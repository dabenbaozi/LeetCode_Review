package com.FourTwo;

public class ConvertBSTToDoublyLinkedList {


    private class Node {
        public int val;
        public Node left, right;
        public Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /*
    * 2 Approaches:**
        1. in-order traverse recursive
        2. in-order traverse iterative
        3. divide and conquer
    * */



//        1. in-order traverse iterative
//        2. divide and conquer/in-order traverse recursive
            Node pre = null;//create a pointer, pointing to prior node
            public Node treeToDoublyList(Node root) {
                if(root == null) {
                    return null;
                }
                //create a dummy node to start building doubly linked list
                //This node will be used to connect head and tail of the linked list
                //in order to make it doubly-linked list.
                Node dummy = new Node(0,null,null);
                //For now make "prev" point to DUMMY
                pre = dummy;
                //recursion rule
                helper(root);
                //first connect from direction: right 1->2->3->4->5
                pre.right = dummy.right;
                dummy.right.left = pre;
                return dummy.right;
            }

            // helper(root) is doing in-order traversal therefore you get a sorted order in your linked list
            private void helper(Node cur) {
                //base case
                if(cur == null) {
                    return;
                }
                //recursion rule
                helper(cur.left);
                pre.right = cur;
                cur.right = pre;
                cur.left = pre;
                pre = cur;
                helper(cur.right);
            }

//              Better for understanding!
//              Step 1: Divide:
//              We divide tree into three parts:
//              left subtree,
//              root node,
//              right subtree.
//              Convert left subtree into a circular doubly linked list as well as the right subtree.
//              Be careful. You have to make the root node become a circular doubly linked list.
//
//              Step 2: Conquer:
//              Firstly, connect left circular doubly linked list with the root circular doubly linked list.
//              Secondly, connect them with the right circular doubly linked list. Here we go!

            public Node treeToDoublyList2(Node root) {
                if(root == null) {
                    return null;
                }
                //get left subtree
                Node leftHead = treeToDoublyList2(root.left);
                //get right subtree
                Node rightHead = treeToDoublyList2(root.right);
                //disconnect
                root.left = root;
                root.right = root;
                //connect left subtree with root
                //than connect right subtree with root
                return connect(connect(leftHead, root), rightHead);
            }

            private Node connect(Node n1, Node n2) {
                if(n1 == null) {
                    return n2;
                }
                if(n2 == null) {
                    return n1;
                }
                Node tail1 = n1.left;
                Node tail2 = n2.left;
                tail1.right = n2;
                n2.left = tail1;
                tail2.right = n1;
                n1.left = tail2;
                return n1;
            }





            /////////Solution from Youtube-> not working!
        /*
            TC:
                1
               / \
              2   3
             / \  /\
            4  5 6  7
            treeToList(1)
            treeToList(2)
            treeToList(4)->treeToList(null)-> left = null, right = null
            ->left - 4
            treeToList(5)->right = 5
            aEnd = 4, bEnd = 2
            treeToList(2)
            treeToList(4)
         */
        //eg: 1<->2<->3   4<->5<->6
        //after concatenate: 1<->2<->3<->4<->5<->6


}
