package com;

import java.util.*;

public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        this.label = x;
        this.neighbors = new ArrayList <UndirectedGraphNode>();
    }
}
