package com.Fifties;

//LC 55 Jump Game
/*
* Given an array of non-negative integers,
* you are initially positioned at the first index of the array.
* Each element in the array represents your maximum jump length at that position.
* Determine if you are able to reach the last index.
* */
public class JumpGame {

    //TC 1: [2,3,1,1,4] -> true
    //TC2: [3,2,1,0,4] ->false
        public boolean canJum(int[] nums) {
            //corner case
            if(nums.length == 0 || nums.length == 1) {
                return true;
            }
            //store true if the node is reachable else false
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;
            for(int j = 1; j<nums.length; j++) {
                //if the node itself is reachable then try to reach it from jth node
                for(int i = 0; i<=j-1;i++) {
                    //check if node i is reachable and the distance from node i to node j is less tham i-j
                    if(dp[i] == true && (j-i)<=nums[i]) {
                        dp[j] = true;
                        break;
                    }
                    //else false is already stored in dp[i]
                }

            }
            return dp[nums.length-1];

        }

}
