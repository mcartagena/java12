package com.mcartagena.datastructure.graphs.topological;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import com.mcartagena.datastructure.graphs.AdjacencySetGraph;
import com.mcartagena.datastructure.graphs.Graph;

public class TopologicalSort {
    public static List<Integer> sort(Graph graph) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            int indegree = graph.getIndegree(vertex);
            indegreeMap.put(vertex, indegree);
//            System.out.println("vertex " + vertex);
//            System.out.println("indegree " + indegree);
            if (indegree == 0) {
                queue.add(vertex);
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            // Dequeue of the nodes from the list if there are more than one.
            // If more than one element exists then it means that the graph
            // has more than one topological sort solution.
            int vertex = queue.poll();
            sortedList.add(vertex);

            List<List<Integer>> adjacentVertices = graph.getAdjacentVertices(vertex);

            for (List<Integer> adjacentVertex : adjacentVertices) {
                int updatedIndegree = indegreeMap.get(adjacentVertex.get(0)) - 1;
//                indegreeMap.remove(adjacentVertex.get(0));
                indegreeMap.put(adjacentVertex.get(0), updatedIndegree);
//                System.out.println("vertex " + adjacentVertex.get(0));
//                System.out.println("indegree " + updatedIndegree);

                if (updatedIndegree == 0) {
                    queue.add(adjacentVertex.get(0));
                }
            }
        }

        if (sortedList.size() != graph.getNumVertices()) {
            throw new RuntimeException("The Graph had a cycle!");
        }

        return sortedList;
    }

    public static void main(String[] args) {
        Graph graph1 = new AdjacencySetGraph(Graph.GraphType.DIRECTED, 5);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(2, 4);
        graph1.addEdge(1, 3);
        graph1.addEdge(4, 1);
        graph1.addEdge(4, 3);

        printList(sort(graph1));
    }

    public static void printList(List<Integer> list) {
        for (int v : list) {
            System.out.print(v + " ");
        }
    }
}
