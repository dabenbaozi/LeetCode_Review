package com.Nineties;


//LC 96. Unique Binary Search Trees->不能直接用95的解Memory Limit Exceeded
public class Unique_Binary_Search_Trees {


    //Sol0: 95 -> get all permutations and then get size of the result list
    //Sol1: DP
    //Time = O(n^2)
    //Space = O(n)
    public int numTree(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for(int i = 2; i<=n; i++) {
            for(int j = 1; j<=i; ++j) {
                G[i] += G[j-1]*G[i-j];
            }
        }
        return G[n];
    }
    //Sol2: Catlan number formular O(n)
    //Mathematical Deduction
    // C0 = 1; Cn+1 = 2(2n+1)/(n+2) * Cn
    // Time = O(N)
    // Space = O(1)
    public int numTrees(int n) {
        long C = 1;
        for(int i = 0; i<n; ++i) {
            C = C*2*(2*i+1)/(i+2);
        }
        return (int)C;
    }
}
