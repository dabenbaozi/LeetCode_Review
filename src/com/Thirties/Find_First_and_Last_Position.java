package com.Thirties;

//LC 34 Find First and Last Position of Element in Sorted Array
public class Find_First_and_Last_Position {

/*
*
* Given an array of integers nums sorted in ascending order,
* find the starting and ending position of a given target value.
* Your algorithm's runtime complexity must be in the order of O(log n).
* If the target is not found in the array, return [-1, -1].
* */

//sorted
//O(logn)-> binary search->left most & right most
    public static void main(String[] args) {
        //TC1:
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        //int[] expected = new int[]{3,4};
        int[] result = findPos(nums, target);
        System.out.println(result[0]+" to "+result[1]);

        // TC2:
        int target2 = 6;
        //int[] expected2 = new int[]{-1,-1};
        int[] result2 =findPos(nums, target2);
        System.out.println("here");
        System.out.println(result2[0]+" to "+result2[1]);
    }

    public static int[] findPos(int[] input, int target) {
        //default result
        int[] targetRange = {-1,-1};
        //find leftmost index
        int leftIdx = helper(input, target, true);
        //if not find
        if(leftIdx == input.length || input[leftIdx] != target) {
            return targetRange;
        }
        //else if find, update index
        targetRange[0] = leftIdx;
        targetRange[1] = helper(input,target, false)-1;
        return targetRange;
    }

    //helper function to find the leftmost or right most index with Binary search
    private static int helper(int[] input, int target, boolean isLeft) {
        int left = 0, right = input.length-1;
        while(left < right) {
            int mid = left+(right-left)/2;
            if(input[mid] > target || isLeft && target == input[mid]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;

    }

}
