package com.Eighties;

public class MergeSortedArray {
    //从后向前比较。 Time Complexity - O(m + n)， Space Complexity - O(1)

    public static void main(String[] args) {
        // write your code here
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int [] nums2 = new int[]{3,4,6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, index = m+n-1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] < nums2[j]) {
                nums1[index--] = nums2[j--];
            } else {
                nums1[index--] = nums1[i--];
            }
        }
        while(i >= 0) {
            nums1[index--] = nums1[i--];
        }
        while(j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
}
