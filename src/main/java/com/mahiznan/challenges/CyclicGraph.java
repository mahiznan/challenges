package com.mahiznan.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 Detect cycle in an undirected graph

 Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.

 */
public class CyclicGraph {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            boolean ans = isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }


    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        printAllPaths(new StringBuilder(), V - 1, 0, 0, adj);
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                path.append(adj.get(i).get(j));
            }
        }
        System.out.println(path);

        return true;
    }


    static void printAllPaths(StringBuilder path, int totalNodes, int visitedNodes, int currentNodeSubPos, ArrayList<ArrayList<Integer>> adj) {
        if (visitedNodes + 1 == totalNodes) {
            System.out.println("End of path " + path);
            return;
        }
        ArrayList<Integer> edges = adj.get(visitedNodes + 1);
        for (int i = currentNodeSubPos; i < edges.size(); i++) {
            if (path.length() > 2 && path.toString().contains("" + edges.get(i))) {
                System.out.println("Cyclic " + path);
            } else {
                path.append(edges.get(i));
                printAllPaths(path, totalNodes, visitedNodes + 1, i, adj);
            }
        }
    }


}
/*

5 5
0 4
1 2
1 4
2 3
3 4

 */