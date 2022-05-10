package com.mcartagena.datastructure.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySetGraph implements Graph {

    private List<Node> vertexList = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencySetGraph(GraphType graphType, int numVertices) {
        this.graphType = graphType;
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            vertexList.add(new Node(i));
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v1 + ", " + v2);
        }

        vertexList.get(v1).addEdge(v2, 1);

        if (graphType == GraphType.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1, 1);
        }
    }

    @Override
    public void addEdge(int v1, int v2, int weight) {
        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v1 + ", " + v2);
        }

        vertexList.get(v1).addEdge(v2, weight);

        if (graphType == GraphType.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1, weight);
        }
    }

    @Override
    public List<List<Integer>> getAdjacentVertices(int v) {
        if (v >= numVertices || v < 0) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v);
        }

        return vertexList.get(v).getAdjacentVertices();
    }

    @Override
    public int getWeightedEdge(int v1, int v2) {
        Node node = vertexList.get(v1);

        List<List<Integer>> adjacentVertices = node.getAdjacentVertices();

        for(List<Integer> adjacentNode : adjacentVertices) {
            if(adjacentNode.get(0) == v2){
                return adjacentNode.get(1);
            }
        }
        // there is not conection between entities
        return 0;
    }

    @Override
    public int getnumVertices() {
        return numVertices;
    }

}
