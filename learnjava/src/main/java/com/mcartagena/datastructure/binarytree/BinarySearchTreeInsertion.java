package com.mcartagena.datastructure.binarytree;

public class BinarySearchTreeInsertion {

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
        insert(head, three);
        insert(head, eight);
        insert(head, two);
        insert(head, nine);
        insert(head, six);
        insert(head, four);

        inOrder(head);
    }

    public static void print(Node node) {
        System.out.print(node.getData() + " ->");
    }

    public static void inOrder(Node head) {
        if (head == null)
            return;

        inOrder(head.getLeftNode());
        print(head);
        inOrder(head.getRightNode());
    }

    public static Node<Integer> insert(Node<Integer> head, Node<Integer> node) {
        if (head == null) {
            return node;
        }

        if (node.getData() <= head.getData()) {
            head.setLeftNode(insert(head.getLeftNode(), node));
        } else {
            head.setRightNode(insert(head.getRightNode(), node));
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
            return data;
        }

        public void setLeftNode(Node<T> leftNode) {
            this.leftNode = leftNode;
        }

        public Node<T> getLeftNode() {
            return leftNode;
        }

        public void setRightNode(Node<T> rightNode) {
            this.rightNode = rightNode;
        }

        public Node<T> getRightNode() {
            return rightNode;
        }

    }
}
