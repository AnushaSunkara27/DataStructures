package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    HashMap<String, ArrayList<String>> adjacencyList 
    = new HashMap<>();

    public void printGraph() {
        System.out.println(adjacencyList);
    }

    public boolean addVertex(String vertex) {
        if(adjacencyList.get(vertex) == null) {
            adjacencyList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if(adjacencyList.get(vertex1) != null && adjacencyList.get(vertex2) != null) {
            adjacencyList.get(vertex1).add(vertex2);
            adjacencyList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if(adjacencyList.get(vertex1) != null && adjacencyList.get(vertex2) != null) {
            adjacencyList.get(vertex1).remove(vertex2);
            adjacencyList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if(adjacencyList.get(vertex) == null) return false;
        for(String otherVertex: adjacencyList.get(vertex)) {
            adjacencyList.get(otherVertex).remove(vertex);
        }
        adjacencyList.remove(vertex);
        return true;
    }

    // Breadth-First Search (BFS)
    public void bfs(String startVertex) {
        if (!adjacencyList.containsKey(startVertex))
            return;

        Queue<String> queue = new LinkedList<>();
        ArrayList<String> visited = new ArrayList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            String currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (String neighbor : adjacencyList.get(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Depth-First Search (DFS)
    public void dfs(String startVertex) {
        if (!adjacencyList.containsKey(startVertex))
            return;

        Stack<String> stack = new Stack<>();
        ArrayList<String> visited = new ArrayList<>();

        stack.push(startVertex);
        visited.add(startVertex);

        while (!stack.isEmpty()) {
            String currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            for (String neighbor : adjacencyList.get(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.printGraph();

        graph.addEdge("A", "C");
        graph.addEdge("A", "B");


        graph.printGraph();

        System.out.print("BFS starting from 'A': ");
        graph.bfs("A");

        System.out.print("DFS starting from 'A': ");
        graph.dfs("A");
    }

    
}
