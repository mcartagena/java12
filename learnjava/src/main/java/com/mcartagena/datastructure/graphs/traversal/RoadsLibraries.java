package com.mcartagena.datastructure.graphs.traversal;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

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
    int[][] adjacencyMatrix = new int[n][n];
    
    for(int i=0; i < n; i++){
        for(int j=0; j< n; j++){
            adjacencyMatrix[i][j] = 0;
        }
    }
    
    // add edge
    cities.forEach(
        inCities -> {
            adjacencyMatrix[inCities.get(0)-1][inCities.get(1)-1] = 1;
            adjacencyMatrix[inCities.get(1)-1][inCities.get(0)-1] = 1;
        }
    );
    
    int[] visited = new int[n];

    ArrayList<Integer> comps    = new ArrayList<>();
    long minCost                = 0;

    for(int i=0; i<n;i++){
        
        if(visited[i] == 0) {
            comps.add(
                depthFirstSearch(n, adjacencyMatrix, visited, i)
            );
        }

    }

    for (int i = 0; i < comps.size(); i++) {
        minCost += Math.min((comps.get(i) - 1) * c_road + c_lib, comps.get(i) * c_lib);
    }

    return minCost;
        
    }

    public static int depthFirstSearch(int n, int[][] graph, int[] visited, int currentVertex){

       visited[currentVertex] = 1;

       int cost = 1;
       
       for (int i = 0; i < n; i++) {           
            if (graph[currentVertex][i] != 0 && visited[i] == 0) {
                cost += depthFirstSearch(n, graph, visited, i);
            }
       }

       return cost;
       
    }
}

public class RoadsLibraries {
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

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

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
