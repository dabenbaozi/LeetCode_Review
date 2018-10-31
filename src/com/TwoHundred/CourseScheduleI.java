package com.TwoHundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleI {

    //gragh-matrix
    private static ArrayList<ArrayList<Integer>> prereq = new ArrayList();
    //BFS
    public static boolean canFinish(int numCourses, int[][] prerequistes) {
        //corner case: no classes
        if(numCourses <= 0) {
            return false;
        }
        //1. build the graph and record the indegree of each vertex
        for(int i = 0; i<numCourses; i++) {
            prereq.add(new ArrayList());
        }
        int[] incoming = new int[numCourses];
        for(int i = 0; i<prerequistes.length; i++) {
            //build the graph
            prereq.get(prerequistes[i][0]).add(prerequistes[i][1]);
            incoming[prerequistes[i][1]]++;
        }
        //2. BFS traverse the graph
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i<numCourses; i++) {
            if(incoming[i] == 0) {
                q.offer(i);
            }
        }
        int totalFinished = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < prereq.get(cur).size(); i++) {
                int index = prereq.get(cur).get(i);
                incoming[index]--;
                if (incoming[index] == 0) {
                    q.offer(index);
                }
            }
            totalFinished++;
        }
        return totalFinished == numCourses;
    }

    //DFS
}
