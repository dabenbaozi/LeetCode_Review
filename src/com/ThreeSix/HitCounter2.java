package com.ThreeSix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

//Sol2 HashMap+LinkedList
public class HitCounter2 {
    int lastSum;
    Map<Integer, Integer> sumBook;
    List<Integer> keys;
    public HitCounter2() {
        lastSum = 0;
        sumBook = new HashMap();
        keys = new ArrayList();
    }


    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        lastSum++;
        keys.add(timestamp);
        sumBook.put(timestamp,lastSum);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int lowerLimit = ((timestamp-300)>0)?timestamp-300:0;
        int upper = 0;
        int lower = 0;
        boolean foundUpper = false;
        boolean foundLower = false;
        for(int i = keys.size()-1; i>=0; i--) {
            if(keys.get(i) <= timestamp&&foundUpper == false) {
                upper = sumBook.get(keys.get(i));
                foundUpper = true;
            }
            if(keys.get(i) <= lowerLimit && foundLower == false) {
                lower = sumBook.get(keys.get(i));
                foundLower = true;
            }
        }
        return upper-lower;
    }

}
