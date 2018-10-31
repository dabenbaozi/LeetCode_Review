package com.FourHundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {

    //TC 1: [0,1,3,5,6,8,12,17]
    //TC 2: [0,1,2,3,4,8,9,11]
    //TC 3: [0,1,2,3,4,5,6,12]-> false
    //DFS-faster
    boolean canPass = false;
    int goal =  -1;
    //DP+HashMap
    public boolean canCross(int[] stones) {
        goal = stones[stones.length-1];
        HashSet<Integer> memo = new HashSet();
        for(int i = 0; i<stones.length; i++) {
            if(i>=3 && stones[i] >2 * stones[i-1]) {
                return false;
            }
            memo.add(stones[i]);
        }
        dfs(memo, 0, 0);
        return canPass;
    }

    private void dfs(HashSet<Integer> memo, int pos, int jump) {
        if(canPass) {
            return;
        }
        if(pos == goal) {
            canPass = true;
        }
        for(int i = 1; i>=-1; i--) {
            int t = pos+i+jump;
            if(!canPass && memo.contains(t) && i+jump >0 && t<=goal) {
                dfs(memo, t, jump+i);
            }

        }
    }


    //DP + HashSet
    //first try the jump as far as possible, if can't then false
    public boolean canCross2(int[] stones) {
        //corner case-> if no stones at all
        if(stones.length == 0) {
            return false;
        }
        //save source -> from where can jump to current
        //HashSet -> save distance range
        Map<Integer, Set<Integer>> map = new HashMap();
        //initialization stone:distance jumped
        for(int i = 0; i<stones.length; i++) {
            map.put(stones[i], new HashSet());
        }
        //default value
        map.get(0).add(0);
        //check each stone->calculate last step
        for(int i = 0; i<stones.length; i++) {
            for(int lastStep:map.get(stones[i])) {
                for(int nextStep = lastStep-1; nextStep <= lastStep+1; nextStep++) {//try jump from [k-1, k+1]
                    //can only jump forward && current stone+jump distance = able to jump on the rock
                    if(nextStep > 0 && map.containsKey(stones[i]+nextStep)) {
                        map.get(stones[i]+nextStep).add(nextStep);
                    }
                }
            }
        }
        return !map.get(stones[stones.length-1]).isEmpty();
    }


}
