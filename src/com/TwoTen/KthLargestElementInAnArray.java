package com.TwoTen;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    //1. Max heap and poll k times
    //Time = O(n)heapify + O(klog(n)) pop k times
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                return -(i1-i2);
            }
        });
        for(int i:nums) {
            maxHeap.add(i);
        }
        int res = 0;
        while(k>0) {
            res =maxHeap.poll();
            k--;
        }
        return res;
    }
    //2. Min head with size k
    //sliding window Time = O(n-k)*log(k)
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int i: nums) {
            if(minHeap.size() < k) {
                minHeap.add(i);
            } else {
                if(minHeap.peek()<i) {
                    minHeap.poll();
                    minHeap.add(i);
                }
            }
        }
        return minHeap.peek();

    }
    //3. Quick select
    //Average = O(n), worst = o(n^2)


}
