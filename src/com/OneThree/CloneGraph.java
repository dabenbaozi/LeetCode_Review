//package com.OneThree;
//
//import com.UndirectedGraphNode;
//
//import java.util.HashMap;
//
//public class CloneGraph {
//
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        //corner case
//        if(node == null) {
//            return node;
//        }
//        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap);
//        DFS(map,node);
//        return map.get(node);
//    }
//
//    private void DFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
//        if(node == null) {
//            return;
//        }
//        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
//        map.put(node,newNode);
//        for(UndirectedGraphNode u:node.neighbors) {
//            if(map.containsKey(u)) {
//                UndirectedGraphNode uCopy = map.get(u);
//                newNode.neighbors.add(uCopy);
//            } else {
//                DFS(map,u);
//                newNode.neighbors.add(map.get(u));
//            }
//        }
//    }
//
//}
