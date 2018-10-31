package com.ThreeSix;

import java.util.LinkedList;
import java.util.Queue;

//LC 362 Design Hit Counter
/*
*
* 维护一个queue, 每次把新的timestamp加进queue里。
* 需要getHits时把queue首部5min之前的全部poll出去后return queue.size().
* Time Complexity: hit O(1), getHits O(queue.size()).
* Space: queue.size().
*
* */

//Sol1 brutal with queue
/*
*
* 思路: 用个链表把时间存起来, 如果取结果的时候把过期数据删掉就行了, 然后如果每秒很多数据,
* 那么就每秒的计数都放在一个结点中, 并且需要另外一个当前计数计数标记, 如果添加了新数据,
* 计数+1, 如果当前队首结点过期了, 就把那一秒内的计数都减去即可.
* */
public class HitCounter {
    Queue<Integer> q ;

    //constructyor
    public HitCounter() {
        this.q = new LinkedList();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek()>= 300) { //300 = 5*60
            q.poll();
        }
        return q.size();
    }

}


