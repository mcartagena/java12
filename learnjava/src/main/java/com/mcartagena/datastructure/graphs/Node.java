package com.mcartagena.datastructure.graphs;

import java.util.*;

public class Node {
    private int vertexNumber;
    private List<List<Integer>> adjacencyList = new ArrayList<>();

    public Node(int vertexNumber){
        this.vertexNumber = vertexNumber;
    }

    public int getVertexNumber(){
        return vertexNumber;
    }

    public void addEdge(int vertexNumber, int weight){
        List<Integer> adjacencyNode = new ArrayList<>();

        adjacencyNode.add(vertexNumber);
        adjacencyNode.add(weight);

        adjacencyList.add(adjacencyNode);

    }

    public List<List<Integer>> getAdjacentVertices() {
        return adjacencyList;
    }
}
