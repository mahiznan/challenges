package com.mahiznan.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class GraphNode {
    ArrayList<GraphNode> neighbors = new ArrayList<>();
    int data;

    GraphNode(int data) {
        this.data = data;
    }
}

public class CloneDirectedGraph {

    static GraphNode deepClone(GraphNode root, HashMap<GraphNode, GraphNode> nodes_completed) {
        if (root == null) {
            return null;
        }
        GraphNode newNode = new GraphNode(root.data);
        nodes_completed.put(root, newNode);

        for (GraphNode neighbour : root.neighbors) {
            GraphNode t = nodes_completed.get(neighbour);
            if (t == null) {
                newNode.neighbors.add(deepClone(neighbour, nodes_completed));
            } else {
                newNode.neighbors.add(t);
            }
        }
        return newNode;
    }


    static void printGraph(GraphNode node, Set<GraphNode> visitedNodes) {
        System.out.print(node.data + "->");
        visitedNodes.add(node);
        for (GraphNode neighbour : node.neighbors) {
            if (!visitedNodes.contains(neighbour)) {
                printGraph(neighbour, visitedNodes);
            }
        }
    }

    public static void main(String[] args) {

        GraphNode node1 = new GraphNode(0);
        GraphNode node2 = new GraphNode(1);
        GraphNode node3 = new GraphNode(2);
        GraphNode node4 = new GraphNode(3);
        GraphNode node5 = new GraphNode(4);

        node1.neighbors.add(node3);
        node1.neighbors.add(node4);
        node1.neighbors.add(node5);

        node2.neighbors.add(node3);

        node3.neighbors.add(node1);

        node4.neighbors.add(node3);

        node5.neighbors.add(node1);
        node5.neighbors.add(node2);
        node5.neighbors.add(node4);

//        printGraph(node1, new HashSet<>());

//        Set<GraphNode> nodes = getNodes(node1, new HashSet<>());
//        System.out.println(nodes.size());
        GraphNode newHead = deepClone(node1, new HashMap<>());
//        printGraph(newHead, new HashSet<>());
    }

    private static Set<GraphNode> getNodes(GraphNode node, Set<GraphNode> nodes) {
        nodes.add(node);
        for (GraphNode neighbour : node.neighbors) {
            if (!nodes.contains(neighbour)) {
                getNodes(neighbour, nodes);
            }
        }
        return nodes;
    }
}
