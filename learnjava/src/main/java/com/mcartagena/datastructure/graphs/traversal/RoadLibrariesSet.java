package com.mcartagena.datastructure.graphs.traversal;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultWithSet {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        System.out.println("n " + n + " c_lib " + c_lib + " c_road " + c_road);
        cities.forEach(city -> {
            System.out.println(city.get(0) + " " + city.get(1));
        });

        List<Node> vertexList = new ArrayList<>();

        long minCost = 0;

        for(int i=0; i<n;i++){
            vertexList.add(new Node(i));
        }

        // add edges
        cities.forEach(
                edge -> {
                    vertexList.get(edge.get(0)-1).addEdge(edge.get(1) -1);
                    vertexList.get(edge.get(1)-1).addEdge(edge.get(0) -1);
                }
        );

        int [] visited = new int[n];

        List<Integer> totalCities = new ArrayList<>();

        for(Node node: vertexList){
            int resultCities = depthFirstSearch(n, vertexList, visited, node);
            if(resultCities != 0){
                totalCities.add(resultCities);
            }
        }

        for(int internalCities: totalCities){
            minCost += Math.min((internalCities - 1)*c_road + c_lib, internalCities * c_lib);
        }

        return minCost;

    }

    public static int depthFirstSearch(int n, List<Node> graph, int[] visited, Node currentVertex){
        if(visited[currentVertex.getVertexNumber()] == 1){
            return 0;
        }

        visited[currentVertex.getVertexNumber()] = 1;
        int nodes = 1;

        for(int i: currentVertex.getAdjacentVertices()){
            nodes += depthFirstSearch(n, graph, visited, graph.get(i));
        }

        return nodes;

    }

    public static class Node {
        private int vertexNumber;
        private Set<Integer> adjacencySet = new HashSet<>();

        public Node(int vertexNumber){
            this.vertexNumber = vertexNumber;
        }

        public int getVertexNumber(){
            return vertexNumber;
        }

        public void addEdge(int vertexNumber){
            adjacencySet.add(vertexNumber);
        }

        public List<Integer> getAdjacentVertices(){
            List<Integer> sortedList = new ArrayList<>(adjacencySet);

            Collections.sort(sortedList);

            return sortedList;
        }
    }
}

public class RoadLibrariesSet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = ResultWithSet.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

