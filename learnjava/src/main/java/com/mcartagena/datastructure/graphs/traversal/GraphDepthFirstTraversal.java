package com.mcartagena.datastructure.graphs.traversal;

import com.mcartagena.datastructure.graphs.AdjacencyMatrixGraph;
import com.mcartagena.datastructure.graphs.Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphDepthFirstTraversal {

    private static int N = 8;

    public static void main(String[] args) {
        Graph graph = new AdjacencyMatrixGraph(N, Graph.GraphType.UNDIRECTED);

        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 7);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 4);

//        int[] visited = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        int[] visited = new int[N];

        // this for-loop ensures that all nodes are connected even for an unconnected graph
        for (int i = 0; i < N; i++) {
            depthFirstTraversal(graph, visited, i);
        }

        visited = new int[N];

        List<Integer> totalNodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int resultNodes = depthFirstSearch(graph, visited, i);
            if (resultNodes != 0) {
                totalNodes.add(resultNodes);
            }
        }

        System.out.println("\nTotal nodes: ");
        totalNodes.forEach(System.out::println);


    }

    public static void depthFirstTraversal(Graph graph, int[] visited, int currentVertex) {
        if (visited[currentVertex] == 1) {
            return;
        }

        visited[currentVertex] = 1;

        List<Integer> list = graph.getAdjacentVertices(currentVertex);

        for (int vertex : list) {
            depthFirstTraversal(graph, visited, vertex);
        }

        System.out.print(currentVertex + "->");

    }

    // objective return number of edges connected
    public static int depthFirstSearch(Graph graph, int[] visited, int currentVertex) {

        if (visited[currentVertex] == 1) {
            return 0;
        }

        visited[currentVertex] = 1;
        int nodes = 1;

        List<Integer> list = graph.getAdjacentVertices(currentVertex);

        for (int vertex : list) {
            nodes += depthFirstSearch(graph, visited, vertex);
        }


        return nodes;
    }

}
