package com.TwoSixties;

import java.util.Arrays;
import java.util.HashSet;

//LC 268. Missing Number
public class Missing_Number {
    //Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
    //find the one that is missing from the array.
    public static void main(String[] args) {
        //TC1:
        int[] input1 = new int[]{3,0,1};//expected 2
        System.out.println(missingNumber(input1));
        System.out.println(missingNumber2(input1));
        System.out.println(missingNumber3(input1));
        System.out.println(missingNumber4(input1));
        //TC2:
        int[] input2 = new int[]{9,6,4,2,3,5,7,0,1};//expected 8
        System.out.println(missingNumber(input2));
        System.out.println(missingNumber2(input2));
        System.out.println(missingNumber3(input2));
        System.out.println(missingNumber4(input2));


    }

    //Sol1: sort & compare with index
    //Time = O(nlogn)
    //Space = O(1) or O(n)->depending if you sort the array in-place
    public static int missingNumber(int[] input) {
        Arrays.sort(input);
        for(int i = 0; i<input.length; i++) {
            if(i != input[i]) {
                return i;
            }
        }
        //if array does not missing any numbers
        return -1;


    }
    //Sol2: add up and minus-Gauss's formula
    //Time = O(n)
    //Space = O(1)
    public static int missingNumber2(int[] input) {
        /*
        *求和过程可以改写成
        * int expectedSum = nums.length*(nums.length+1)/2;
        * Gauss's formula:
        * n(n+1)/2
        */

        int sum = 0;
        for(int i:input) {
            sum += i;
        }
        int n = 0;
        for(int i = 0; i<=input.length; i++) {
            n+=i;
        }
        return n-sum;

    }
    //Sol3: HashSet
    //Time = O(2n) = O(n)
    //Space = O(n+1) = O(n)
    public static int missingNumber3(int[] input) {
        HashSet<Integer> set = new HashSet();
        for(int i : input) {
            set.add(i);
        }
        int n = input.length+1;
        for(int i = 0; i<n; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
    //Sol4: bit operation
    //Time = O(n)
    //Space = O(1)
    //XOR is its own inverse to find the missing element in linear time
    public static int missingNumber4(int[] nums) {
        int missing = nums.length;
        for(int i = 0; i<nums.length; i++) {
            missing ^= i^nums[i];
        }
        return missing;
    }



}
