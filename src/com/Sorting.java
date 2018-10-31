package com;

public class Sorting {
    //1. MergeSort
    /*
    * divide and conquer, stable
    * Time = O(nlogn), Space = O(n)
    *
    *
    *
    * */
    public int[] mergeSort(int[] array) {
        //corner case
        if(array == null || array.length <= 1) {
            return array;
        }
        //process
        //helper array
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length-1);
        return array;
    }

    private int[] mergeSort(int[] array, int[] helper, int left, int right) {
        //base case
        if(left >= right) {
            return array;
        }
        int mid = left+(right-left)/2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid+1, right);
        return merge(array, helper, left, mid, right);
    }

    private int[] merge(int[] array, int[] helper, int left, int mid, int right) {
        //1. copy array to helper array
        for(int i = 0; i<helper.length; i++) {
            helper[i] = array[i];
        }
        //2. compare and move 2 pointers
        int leftIndex = left, rightIndex = mid+1;
        while(leftIndex <= mid && rightIndex <= right ) {
            if(helper[leftIndex] < helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }
        //3. check if element left in the left side and copy them over
        while(leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }
        return array;
    }

}
