package com.OneTwo;

import java.util.HashSet;
import java.util.Set;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

        Your algorithm should run in O(n) complexity.

        Example:

        Input: [100, 4, 200, 1, 3, 2]
        Output: 4
        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
    */
//LC 128 Longest Consecutive Sequence
public class LongestConsecutiveSequence {



    public static int findLongest(int[] nums) {
        //corner case
        if(nums == null || nums.length <= 0) {
            return 0;
        }
        //transfer to set
        Set<Integer> set = new HashSet();
        for(int i: nums) {
            set.add(i);
        }
        //return value
        int result = 1;
        //go through each number
        for(int i: nums) {
            //find the beginning of each sequence
            if(!set.contains(i-1)) {
                int cur = i;
                int temp = 1;
                while(set.contains(cur+1)) {
                    cur += 1;
                    temp += 1;
                }
                //update result
                result = Math.max(result, temp);
            }

        }
        return result;

    }
}
