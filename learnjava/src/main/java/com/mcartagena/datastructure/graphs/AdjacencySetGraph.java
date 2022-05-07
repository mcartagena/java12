package com.mcartagena.datastructure.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySetGraph implements Graph{

    private List<Node> vertexList = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencySetGraph(GraphType graphType, int numVertices) {
        this.graphType = graphType;
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++){
            vertexList.add(new Node(i));
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        if(v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0){
            throw new IllegalArgumentException("Vertex number is not valid: " + v1 + ", " + v2);
        }

        vertexList.get(v1).addEdge(v2);

        if(graphType == GraphType.UNDIRECTED){
            vertexList.get(v2).addEdge(v1);
        }
    }

    @Override
    public void addEdge(int v1, int v2, int weight) {
        throw new IllegalArgumentException("Weight not implemented in Adjacency Set");
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v >= numVertices || v < 0) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v);
        }

        return vertexList.get(v).getAdjacentVertices();
    }

    @Override
    public int getWeightedEdge(int v1, int v2) {
        throw new IllegalArgumentException("Weight not implemented in Adjacency Set");
    }

    @Override
    public int getnumVertices() {
        return numVertices;
    }

}
