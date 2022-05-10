package com.mcartagena.datastructure.graphs.shortestpath;

import com.mcartagena.datastructure.graphs.AdjacencyMatrixGraph;
import com.mcartagena.datastructure.graphs.Graph;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
        graph1.addEdge(2, 7, 4);
        graph1.addEdge(0, 3, 2);
        graph1.addEdge(0, 4, 2);
        graph1.addEdge(0, 1, 1);
        graph1.addEdge(2, 1, 3);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(3, 5, 1);
        graph1.addEdge(3, 6, 3);
        graph1.addEdge(4, 7, 2);
        graph1.addEdge(7, 5, 4);

        shortestPath(graph1, 0, 5);
    }

    public static void shortestPath(Graph graph, int source, int destination) {
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
            System.out.println(" Dijkstra  DONE!");
        }
    }

    private static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();

        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(
                new Comparator<VertexInfo>() {

                    @Override
                    public int compare(VertexInfo o1, VertexInfo o2) {
                        return ((Integer) o1.getDistance()).compareTo(o2.getDistance());
                    }
                }
        );

        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();

        for (int i = 0; i < graph.getnumVertices(); i++) {
            distanceTable.put(i, new DistanceInfo());
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);

        queue.offer(sourceVertexInfo);
        vertexInfoMap.put(source, sourceVertexInfo);

        while (!queue.isEmpty()) {
            VertexInfo vertexInfo = queue.poll();
            int currentVertex = vertexInfo.getVertexId();

            for (List<Integer> neighbor : graph.getAdjacentVertices(currentVertex)) {

                int distance = distanceTable.get(currentVertex).getDistance() + graph.getWeightedEdge(currentVertex, neighbor.get(0));

                if (distanceTable.get(neighbor).getDistance() > distance) {
                    distanceTable.get(neighbor).setDistance(distance);
                    distanceTable.get(neighbor).setLastVertex(currentVertex);

                    VertexInfo neighborVertexInfo = vertexInfoMap.get(neighbor);
                    if (neighborVertexInfo != null) {
                        queue.remove(neighborVertexInfo);
                    }

                    neighborVertexInfo = new VertexInfo(neighbor.get(0), distance);
                    queue.offer(neighborVertexInfo);
                    vertexInfoMap.put(neighbor.get(0), neighborVertexInfo);
                }

            }
        }

        return distanceTable;
    }

    public static class DistanceInfo {
        private int distance;
        private int lastVertex;

        public DistanceInfo() {
            distance = Integer.MAX_VALUE;
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

        @Override
        public String toString() {
            return "DistanceInfo{" +
                    "distance=" + distance +
                    ", lastVertex=" + lastVertex +
                    '}';
        }
    }


    public static class VertexInfo {
        private int vertexId;
        private int distance;

        public VertexInfo(int vertexId, int distance) {
            this.vertexId = vertexId;
            this.distance = distance;
        }

        public int getVertexId() {
            return vertexId;
        }

        public void setVertexId(int vertexId) {
            this.vertexId = vertexId;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
