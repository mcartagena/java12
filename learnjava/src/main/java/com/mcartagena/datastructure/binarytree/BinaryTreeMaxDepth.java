package com.mcartagena.datastructure.binarytree;

public class BinaryTreeMaxDepth {

    public static void main(String[] args) {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> nine = new Node<>(9);

        Node<Integer> head = insert(null, five);

        insert(head, one);
        insert(head, seven);
        insert(head, nine);
        insert(head, six);
        insert(head, four);
        insert(head, three);
        insert(head, eight);
        insert(head, two);

        System.out.println("Max Depth: " + maxDepth(head));
    }

    public static int maxDepth(Node<Integer> head){
        if(head == null){
            return 0;
        }

        if(head.getRigthNode() == null && head.getLeftNode() == null){
            return 0;
        }

        int leftMaxDepth = 1 + maxDepth(head.getLeftNode());
        int rightMaxDepth = 1 + maxDepth(head.getRigthNode());

        return Math.max(leftMaxDepth, rightMaxDepth);

    }

    public static Node<Integer> insert(Node<Integer> head, Node<Integer> node) {
        if (head == null) {
            return node;
        }

        if (node.getData() <= head.getData()) {
            head.setLeftNode(insert(head.getLeftNode(), node));
        } else {
            head.setRightNode(insert(head.getRigthNode(), node));
        }
        return head;
    }

    public static class Node<T> {
        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }

        public void setLeftNode(Node<T> node) {
            this.leftNode = node;
        }

        public Node<T> getLeftNode() {
            return this.leftNode;
        }

        public void setRightNode(Node<T> node) {
            this.rightNode = node;
        }

        public Node<T> getRigthNode() {
            return this.rightNode;
        }
    }
}
