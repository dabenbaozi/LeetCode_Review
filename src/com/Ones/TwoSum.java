package com.Ones;


import java.util.Arrays;
import java.util.HashMap;

import static com.PrintFunctions.printArray;

//LC 1. Two Sum
public class TwoSum {
    /*
    * Given an array of integers, return indices of the two numbers
    * such that they add up to a specific target.
    * You may assume that each input would have exactly one solution,
    * and you may not use the same element twice.
    * */
    public static void main(String[] args) {
        int[] TC1 = new int[]{2, 7, 11, 15};
        int target = 9;
        printArray(twoSum(TC1, target));
        System.out.println("TC2");
        printArray(twoSum2(TC1, target));
        System.out.println("TC3");
        printArray(twoSum3(TC1, target));
        System.out.println("TC4");
        printArray(twoSum4(TC1, target));

    }

    //sol 1:
    //Time = O(n^2)
    //Space = O(n)
    public static int[] twoSum(int[] num, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        for(int i = 0; i<num.length-1; i++) {
            for(int j = i+1; j<num.length; j++) {
                if(num[i] + num[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    //Sol 2: two-pointers
    //Time = O(nlogn)->sort+2 pointers??
    //Space = O(n)
    public static int[] twoSum2(int[] num, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        //1. sort
        Arrays.sort(num);
        int left = 0, right = num.length-1;
        while(left < right) {
            int cur = num[left] + num[right];
            if(cur == target) {
                result[0] = left;
                result[1] = right;
                break;
            } else if(cur < target) {
                left++;
            } else {
                right--;
            }
        }

    return result;
    }

    //Sol3: two pass Hashing
    //Time = O(2n)
    //Space = O(n)
    public static int[] twoSum3(int[] num, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        HashMap<Integer, Integer> map = new HashMap();
        //first pass, store value & pos
        for(int i = 0; i<num.length; i++) {
            map.put(num[i],i);
        }
        //second pass
        for(int i = 0; i<num.length; i++) {
            if(map.containsKey(target-num[i])) {
                res[0] = i;
                res[1] = map.get(target-num[i]);
                break;
            }
        }
        return res;
    }

    //Sol3: one pass Hashing, saving and look up at the same time
    //Time = O(n)
    //Space = O(n)
    public static int[] twoSum4(int[] num, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i<num.length;i++) {
           map.put(num[i],i);
           if(map.containsKey(target-num[i])) {
               res[0] = i;
               res[1] = map.get(target-num[i]);
               break;
           }

        }
        return res;
    }


}
