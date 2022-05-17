package com.mcartagena.datastructure.binarytree;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SwapNodes {

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        // Write your code here
        List<List<Integer>> listResult = new ArrayList<>();

        // build the tree

        Node<Integer> head = insert(indexes);

        // navigate the tree in-Order return the print
        queries.forEach( num -> {
            // mirror the tree
            mirror(head, num);

            List<Integer> listPrint = new ArrayList<>();
            inOrder(head, listPrint);
            listResult.add(listPrint);

        });

        return listResult;
    }

    public static void mirror(Node<Integer> head, int k){
        Stack<Node> currentLevel = new Stack<Node>();
        Stack<Node>  nextLevel = new Stack<Node>();
        int level = 1;
        Node<Integer> temp;

        currentLevel.push(head);
        while(!currentLevel.isEmpty()){

            temp = currentLevel.pop();

            if(temp.getLeftNode()!=null){
                nextLevel.push(temp.getLeftNode());
            }
            if(temp.getRightNode()!=null){
                nextLevel.push(temp.getRightNode());
            }

            if(level % k == 0){
                Node<Integer> node = temp.getRightNode();
                temp.setRightNode(temp.getLeftNode());
                temp.setLeftNode(node);
            }

            if(currentLevel.isEmpty()){
                Stack<Node> tempStack = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempStack;
                level++;
            }
        }
    }

    public static void print(Node<Integer> node){
        System.out.print(node.getData() + " -> ");
    }

    public static void inOrder(Node<Integer> head, List<Integer> listPrint){
        if(head == null){
            return;
        }

        inOrder(head.getLeftNode(), listPrint);
        // print(head);
        listPrint.add(head.getData());
        inOrder(head.getRightNode(), listPrint);
    }

    public static Node<Integer> insert(List<List<Integer>> indexes){
        Node<Integer> head = new Node<>(1);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);

        indexes.forEach( list -> {
            Node<Integer> node = queue.poll();

            Node<Integer> leftNode, rightNode;

            int left = list.get(0);
            int right = list.get(1);

            if(left != -1){
                leftNode = new Node<>(left);
                node.setLeftNode(leftNode);
                queue.offer(leftNode);
            }

            if(right != -1) {
                rightNode = new Node<>(right);
                node.setRightNode(rightNode);
                queue.offer(rightNode);
            }
        });

        return head;
    }

    public static class Node<T> {
        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data){
            this.data = data;
        }

        public T getData(){
            return data;
        }

        public void setLeftNode(Node<T> node){
            leftNode = node;
        }
        public Node<T> getLeftNode(){
            return leftNode;
        }

        public void setRightNode(Node<T> node){
            rightNode = node;
        }
        public Node<T> getRightNode(){
            return rightNode;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> result = swapNodes(indexes, queries);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

