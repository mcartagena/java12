package com.mcartagena.datastructure.graphs;

import java.util.List;

public interface Graph {

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    void addEdge(int v1, int v2);

    void addEdge(int v1, int v2, int weight);

    List<List<Integer>> getAdjacentVertices(int v);

    int getWeightedEdge(int v1, int v2);

    int getnumVertices();

}