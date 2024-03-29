package com.mcartagena.datastructure.graphs.shortestpath;

import com.mcartagena.datastructure.graphs.AdjacencyMatrixGraph;
import com.mcartagena.datastructure.graphs.Graph;

import java.util.*;

public class BellmanFord {

    public static void main(String[] args) {
        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
        graph1.addEdge(2, 7, 4);
        graph1.addEdge(0, 3, 23);
        graph1.addEdge(0, 4, 23);
        graph1.addEdge(0, 1, 1);
        graph1.addEdge(2, 1, 3);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(3, 5, 1);
        graph1.addEdge(3, 6, 3);
        graph1.addEdge(4, 7, 2);
        graph1.addEdge(7, 5, 4);

//        shortestPath(graph1, 0, 5);

        Graph graph2 = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        graph2.addEdge(0, 1, 2);
        graph2.addEdge(0, 2, 1);
        graph2.addEdge(1, 3, 3);
        graph2.addEdge(1, 4, -2);
        graph2.addEdge(2, 4, 2);
        graph2.addEdge(4, 3, 1);
        graph2.addEdge(2, 1, -5);

//        shortestPath(graph2, 0, 3);

        Graph graph3 = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        graph3.addEdge(0, 1, 2);
        graph3.addEdge(0, 2, 3);
        graph3.addEdge(3, 1, 2);
        graph3.addEdge(1, 4, -5);
        graph3.addEdge(2, 4, 6);
        graph3.addEdge(4, 3, -4);

//        shortestPath(graph3, 0, 3);

        Graph graph4 = new AdjacencyMatrixGraph(6, Graph.GraphType.DIRECTED);
        graph4.addEdge(0, 1, 2);
        graph4.addEdge(1, 2, 3);
        graph4.addEdge(2, 3, 2);
        graph4.addEdge(3, 4, -5);
        graph4.addEdge(3, 5, 1);
        graph4.addEdge(4, 5, -3);
        graph4.addEdge(5, 4, -3);

        shortestPath(graph4, 0, 5);

    }

    public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();

        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo());
        }

        // set up the distance of the specific source
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        Queue<Integer> queue = new LinkedList<>();

        // Relaxing (processing) all the edges numVertices -1 times
        for (int numIterations = 0; numIterations < graph.getNumVertices() - 1; numIterations++) {
            // Add every vertex to the queue so we're sure to access all the edges
            // in the graph
            for (int v = 0; v < graph.getNumVertices(); v++) {
                queue.offer(v);
            }

            // keep track of the edges visited so we visit each edge just once
            // in every iteration
            Set<String> visitedEdges = new HashSet<>();

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();

                for (List<Integer> neighbor : graph.getAdjacentVertices(currentVertex)) {
                    String edge = String.valueOf(currentVertex) + String.valueOf(neighbor.get(0));

                    // Do not visit edges more than once in each iteration
                    if (visitedEdges.contains(edge)) {
                        continue;
                    }

                    visitedEdges.add(edge);

                    int distance = distanceTable.get(currentVertex).getDistance()
                            + graph.getWeightedEdge(currentVertex, neighbor.get(0));

                    // if we find a new shortest path to the neightbor update
                    // the distance and the last vertex
                    if (distanceTable.get(neighbor.get(0)).getDistance() > distance) {
                        distanceTable.get(neighbor.get(0)).setDistance(distance);
                        distanceTable.get(neighbor.get(0)).setLastVertex(currentVertex);
                    }
                }
            }
        }

        // Add all the vertices to the queue one last time to check for
        // a negative cycle
        for (int v = 0; v < graph.getNumVertices(); v++) {
            queue.offer(v);
        }

        // Relaxing (processing) all the edges one last time to check if
        // there exists a negative cycle
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (List<Integer> neighbor : graph.getAdjacentVertices(currentVertex)) {
                int distance = distanceTable.get(currentVertex).getDistance()
                        + graph.getWeightedEdge(currentVertex, neighbor.get(0));

                if (distanceTable.get(neighbor.get(0)).getDistance() > distance) {
                    throw new IllegalArgumentException("The graph has a -ve cycle");
                }
            }
        }

        return distanceTable;

    }

    public static void shortestPath(Graph graph, Integer source, Integer destination) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();

        while (previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        if (previousVertex == -1) {
            System.out.println("There is no path from node: " + source
                    + " to node: " + destination);
        } else {
            System.out.print("Smallest Path is " + source);
            while (!stack.isEmpty()) {
                System.out.print(" -> " + stack.pop());
            }
            System.out.println("\n BellmanFord DONE!");
        }

    }

    public static class DistanceInfo {
        private int distance;
        private int lastVertex;

        public DistanceInfo() {
            distance = 100000;
            lastVertex = -1;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getLastVertex() {
            return lastVertex;
        }

        public void setLastVertex(int lastVertex) {
            this.lastVertex = lastVertex;
        }
    }
}
