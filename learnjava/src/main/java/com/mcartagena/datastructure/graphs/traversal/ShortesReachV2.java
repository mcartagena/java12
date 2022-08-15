package com.mcartagena.datastructure.graphs.traversal;

import java.io.*;
import java.util.*;

public class ShortesReachV2 {

    enum GraphType{
        DIRECTED,
        UNDIRECTED
    }

    public static void breadthFirstTraversal(AdjacencySetGraph graph, int[] visited,
                                             int currentVertex, Map<Integer,Integer> distanceTable){
        Queue<Integer> queue = new LinkedList<>();

        distanceTable.put(currentVertex, 0);
        visited[currentVertex] = 1;

        queue.offer(currentVertex);

        while(!queue.isEmpty()){
            int vertex = queue.poll();

            List<Integer> adjacentNodes = graph.getAdjacentNodes(vertex);
            for(int v:adjacentNodes){
                if(visited[v]!=1){
                    queue.offer(v);
                    distanceTable.put(v, distanceTable.get(vertex) + 6);
                    visited[v] = 1;
                }
            }
        }

    }

    public static class AdjacencySetGraph{
        private ShortesReachV2.GraphType graphType;
        private int numberVertices;
        private List<Node> nodes = new ArrayList<>();

        public AdjacencySetGraph(int numberVertices, ShortesReachV2.GraphType graphType){
            this.numberVertices = numberVertices;
            this.graphType = graphType;
            for(int i=0; i<numberVertices;i++){
                nodes.add(new Node(i));
            }
        }

        public void addEdge(int v1, int v2){
            nodes.get(v1).addEdge(v2);
            if(this.graphType == ShortesReachV2.GraphType.UNDIRECTED){
                nodes.get(v2).addEdge(v1);
            }
        }

        public List<Integer> getAdjacentNodes(int v){
            return nodes.get(v).getAdjacentNodes();
        }
    }

    public static class Node{
        private int vertexId;
        private Set<Integer> adjacentNodes = new HashSet<>();

        public Node(int vertexId){
            this.vertexId = vertexId;
        }

        public int getVertexId(){
            return this.vertexId;
        }

        public void addEdge(int vertexNumber){
            this.adjacentNodes.add(vertexNumber);
        }
        public List<Integer> getAdjacentNodes(){
            List<Integer> sortedList = new ArrayList<>(adjacentNodes);

            Collections.sort(sortedList);

            return sortedList;
        }
    }

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int q = Integer.valueOf(bufferedReader.readLine());

        for(int i=0; i<q;i++){
            String[] arrayString = new String[2];
            arrayString = bufferedReader.readLine().split("\\s");
            int n = Integer.valueOf(arrayString[0]);
            int m = Integer.valueOf(arrayString[1]);

            AdjacencySetGraph graph = new AdjacencySetGraph(n, ShortesReachV2.GraphType.UNDIRECTED);

            for(int j=0;j<m;j++){
                String[] arrayEdges = new String[2];
                arrayEdges = bufferedReader.readLine().split("\\s");
                int v1 = Integer.valueOf(arrayEdges[0]);
                int v2 = Integer.valueOf(arrayEdges[1]);
                graph.addEdge(v1-1, v2-1);
            }
            int s = Integer.valueOf(bufferedReader.readLine());

            Map<Integer,Integer> distanceTable = new HashMap<>();

            int[] visited = new int[n];

            breadthFirstTraversal(graph, visited, s-1, distanceTable);

            for(int p=0;p<n;p++){
                if(p!=s-1){
                    int valueToPrint = visited[p]==1?distanceTable.get(p):-1;
                    System.out.print(valueToPrint + " ");
                }
            }
            System.out.println();
        }
        bufferedReader.close();
    }
}

