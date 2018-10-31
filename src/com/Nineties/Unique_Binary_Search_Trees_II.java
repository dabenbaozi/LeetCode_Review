package com.Nineties;


import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

//LC 95. Unique Binary Search Trees II

public class Unique_Binary_Search_Trees_II {
    //Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
    public static void main(String[] args) {
        Unique_Binary_Search_Trees_II n = new Unique_Binary_Search_Trees_II();
        n.generateTrees(3);
    }
    /*
    *
    * 这是卡特兰数的一种应用，采用动态规划：(* 可以看出这也是一个可以划分成子问题求解的题目，所以考点是动态规划。)
    * 1.从start到end，逐个取出一个rootVal作为根节点（n阶原问题）
    * 2.以根rootVal为界划分为左右子树，并指向左右子树（n-1阶子问题）
    * 3.反复递归：
    * 但具体对于本题来说，采取的是自底向上的求解过程。
    * 1. 选出根结点后应该先分别求解该根的左右子树集合，也就是根的左子树有若干种，它们组成左子树集合，根的右子树有若干种，它们组成右子树集合。
    * 2. 然后将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与所有的左子树匹配。然后将两个子树插在根结点上。
    * 3. 最后，把根结点放入表中。
    * */

    public List<TreeNode> generateTrees(int n) {
        if(n < 1) {
            return new ArrayList<TreeNode>();
        }
        return generateSubTree(1,n);
    }

    public ArrayList<TreeNode> generateSubTree(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end) {
            result.add(null);
            return result;
        }
        for(int rootVal = start; rootVal <= end; rootVal ++) {
            List<TreeNode> leftChild = generateSubTree(start, rootVal-1);
            List<TreeNode> rightChild = generateSubTree(rootVal+1, end);
            for(TreeNode left:  leftChild) {
                for(TreeNode right: rightChild) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }

        }
        return result;
    }


}
