package com.TwoThree;

public class ProductExceptSelf {
    /*
    * Given an array nums of n integers where n > 1,
    * return an array output such that output[i] is equal to the product of all the elements of nums
    * except nums[i].
    把array分成左右两半来处理
    先for loop一遍得到X位置左边的乘积
    再for loop一遍得到x位置右边的乘积
    * */
    public int[] productExceoptSelf(int[] nums) {
       int n = nums.length;
       int[] res = new int[n];
       res[0] = 1;
       for(int i = 1; i<n;i++) {
           res[i] = res[i-1]*nums[i-1];
       }
       int right = 1;
       for(int i = n-1; i>=0; i--) {
           res[i] *=right;
           right *= nums[i];
       }
       return res;
    }

}
