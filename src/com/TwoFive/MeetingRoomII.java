package com.TwoFive;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MeetingRoomII {
    /*Solution 1:
        PQ:
     */
    public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }
    public int minMeetingRooms(Interval[] intervals) {
        //corner case
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        //sort array by start time
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start-b.start;
            }
        });

        //create pq by end time
        PriorityQueue<Interval> pq = new PriorityQueue(intervals.length, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        //add 1 room first and go over see overlaps
        pq.offer(intervals[0]);
        for(int i = 1; i<intervals.length; i++) {
            Interval cur = pq.poll();
            if(cur.end <= intervals[i].start) {
                cur.end = intervals[i].end;
            } else {
                pq.offer(intervals[i]);
            }
            pq.offer(cur);
        }
        return pq.size();
    }
}
