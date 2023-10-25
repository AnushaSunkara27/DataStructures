package Graphs;

import java.util.ArrayList;
import java.util.HashMap;

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

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.printGraph();

        graph.addEdge("A", "C");

        graph.printGraph();
    }

    
}
