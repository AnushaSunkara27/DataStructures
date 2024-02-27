package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecursiveTraversals {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    public RecursiveTraversals(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        
        for(int i=0; i<vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        // Add an edge to the adjacency list (undirected graph)
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        dfsRecursive(startVertex, visited);
    }

    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex + " ");

        // Recursively visit all adjacent vertices
        for(int neighbor: adjacencyList.get(vertex)) {
            if(!visited[neighbor]) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            // Visit all neighbors of the current vertex
            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        RecursiveTraversals graph = new RecursiveTraversals(5);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.println("DFS starting from vertex 0:");
        graph.dfs(0);
    }
}