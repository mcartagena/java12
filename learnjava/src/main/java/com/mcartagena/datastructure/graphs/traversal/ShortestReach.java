package com.mcartagena.datastructure.graphs.traversal;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class ResultShortest {
    public static List<Integer> shortestReach(int n, int s, List<List<Integer>> cities) {
        List<Integer> distances = new ArrayList();
        List<Integer> result = new ArrayList();

        IntStream.range(0, n).forEach(m ->
                distances.add(-1)
        );

        List<Node> graph = new ArrayList<>();

        IntStream.range(0, n).forEach(city ->
                graph.add(new Node(city))
        );

        cities.forEach(
                edge -> {
                    graph.get(edge.get(0) - 1).addEdge(edge.get(1) - 1, 6);
                    graph.get(edge.get(1) - 1).addEdge(edge.get(0) - 1, 6);
                }
        );

        int[] visited = new int[n];

        distances.set(s - 1, 0);

        breadthFirstTraversal(graph, visited, graph.get(s - 1), distances);

        for (int i = 0; i < n; i++) {
            if (i == (s - 1)) {
                continue;
            }
            result.add(visited[i] == 1 ? distances.get(i) : -1);
        }

        return result;
    }

    public static void breadthFirstTraversal(List<Node> graph, int[] visited, Node currentVertex, List<Integer> distances) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(currentVertex);

        while (!queue.isEmpty()) {
            Node vertex = queue.poll();

            if (visited[vertex.getVertexNumber()] == 1) {
                continue;
            }

            visited[vertex.getVertexNumber()] = 1;

            List<List<Integer>> list = graph.get(vertex.getVertexNumber()).getAdjacentVertices();

            for (List<Integer> v : list) {
                if (visited[v.get(0)] != 1) {
                    distances.set(v.get(0), distances.get(vertex.getVertexNumber()) + v.get(1));
                    queue.offer(graph.get(v.get(0)));
                }
            }

        }

    }

    public static class Node {
        private int vertexNumber;
        private List<List<Integer>> adjacencyList = new ArrayList<>();

        public Node(int vertexNumber) {
            this.vertexNumber = vertexNumber;
        }

        public int getVertexNumber() {
            return vertexNumber;
        }

        public void addEdge(int vertexNumber, int weight) {
            List<Integer> adjacencyNode = new ArrayList<>();

            adjacencyNode.add(vertexNumber);
            adjacencyNode.add(weight);

            adjacencyList.add(adjacencyNode);
        }

        public List<List<Integer>> getAdjacentVertices() {

            return adjacencyList;
        }
    }


}

public class ShortestReach {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qry -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);
                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> cities = new ArrayList();

                IntStream.range(0, m).forEach(edge -> {
                            try {
                                cities.add(
                                        Stream.of(
                                                        bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")
                                                )
                                                .map(Integer::parseInt)
                                                .collect(toList())
                                );
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                );

                int s = Integer.parseInt(bufferedReader.readLine().trim());

               /* System.out.println("n " + n + " m " + m);
               cities.forEach(edge -> {
                   System.out.println(edge.get(0) + "-" + edge.get(1));
               });

               System.out.println("s " + s);
               */
                List<Integer> result = ResultShortest.shortestReach(n, s, cities);

                String resultString = result.stream()
                        .map(num -> String.valueOf(num))
                        .collect(Collectors.joining(" "));

                bufferedWriter.write(resultString);
                bufferedWriter.newLine();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();

    }
}

