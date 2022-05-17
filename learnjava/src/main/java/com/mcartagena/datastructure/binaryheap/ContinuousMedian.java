package com.mcartagena.datastructure.binaryheap;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ContinuousMedian {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> result = new ArrayList<>();
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> highers = new PriorityQueue<>();

        a.forEach(num -> {
            add(num, lowers, highers);
            balanceQueues(lowers, highers);
            result.add(getMedian(lowers, highers));
        });

        return result;
    }

    public static void add(int value, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || value < lowers.peek()) {
            lowers.offer(value);
        } else {
            highers.offer(value);
        }
    }

    public static void balanceQueues(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if ((lowers.size() - highers.size()) >= 2) {
            highers.offer(lowers.poll());
        } else if ((highers.size() - lowers.size()) >= 2) {
            lowers.offer(highers.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == highers.size()) {
            return ((double) lowers.peek() + highers.peek()) / 2;
        } else if (lowers.size() > highers.size()) {
            return (double) lowers.peek();
        } else {
            return (double) highers.peek();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

