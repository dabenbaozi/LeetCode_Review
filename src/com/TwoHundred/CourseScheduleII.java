package com.TwoHundred;

import java.util.*;

public class CourseScheduleII {
    //deduct from 207
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> prereq = new ArrayList();
        //build graph
        for(int i = 0; i<numCourses; i++) {
            prereq.add(new ArrayList());
        }
        for(int i = 0; i<prerequisites.length; i++) {
            prereq.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        //BFS
        Queue<Integer> q = new LinkedList();
        int[] order = new int[numCourses];
        int count = 0;
        //add start points into queue
        for(int i = 0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            order[count] = cur;
            for(int i = 0; i<prereq.get(cur).size(); i++) {
                int index = prereq.get(cur).get(i);
                indegree[index]--;
                if(indegree[index] == 0) {
                    q.offer(index);
                }
            }
            count++;
        }
        return count == numCourses?order:new int[0];
    }









    //Online fast
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList();
        initGraph(indegree, adj, prerequisites);
        //return bfs(indegree, adj);
        return solveByDfs(indegree, adj);
    }
    public void initGraph(int[] indegree, List<List<Integer>> adj, int[][] prereq) {
        for(int i = 0; i<indegree.length; i++) {
            adj.add(new ArrayList());
        }
        for(int[] req:prereq) {
            int pre = req[1], next = req[0];
            indegree[next]++;
            adj.get(pre).add(next);
        }
    }

    public int[] solveByDfs(int[] indegree, List<List<Integer>> adj) {
        int num = indegree.length; // == numCourses
        int[] order = new int[num]; //buffer to store current solution
        Deque<Integer> stack = new ArrayDeque();
        int[] visited = new int[num]; //check if been here before
        for(int i = 0; i<num; i++) {
            if(visited[i] == 2) {
                continue;
            }
            if(visited[i] == 0) {
                if(!dfs(i, adj, visited, stack)) {
                    return new int[0];
                }
            }
        }
        for(int i = 0; i<num; i++) {
            order[i] = stack.pop();
        }
        return order;
    }

    public boolean dfs(int course, List<List<Integer>> adj, int[] visited, Deque<Integer> stack) {
        visited[course] = 1;//visited current travel
        for(int neigh: adj.get(course)) {
            if(visited[neigh] == 1) {
                return false; //cycle
            }
            if(visited[neigh] == 0) {
                if(!dfs(neigh, adj, visited, stack)) {
                    return false;
                }
            }
        }
        visited[course] = 2;
        stack.push(course);
        return true;
    }


    public int[] bfs(int[] indegree, List<List<Integer>> adj) {
        Queue<Integer> toVisit = new LinkedList();
        int numCourses = indegree.length;
        int[] order = new int[numCourses];
        for(int i = 0; i<indegree.length; i++) {
            if(indegree[i] == 0) {
                toVisit.add(i);
            }
        }
        int count = 0;
        while(! toVisit.isEmpty()) {
            int cur = toVisit.poll();
            order[count++] = cur;
            for(int neigh:adj.get(cur)) {
                if(--indegree[neigh] == 0) {
                    toVisit.add(neigh);
                }
            }
        }
        return count == numCourses?order:new int[0];
    }
}
