package com.mcartagena.datastructure.binarytree;

public class DepthFirstTraversal {

    public static void main(String[] args) {
        Node<Character> a = new Node<>('A');
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');
        Node<Character> h = new Node<>('H');
        Node<Character> x = new Node<>('X');

        a.setLeftNode(b);
        a.setRightNode(c);
        c.setLeftNode(d);
        c.setRightNode(e);
        d.setLeftNode(f);
        d.setRightNode(h);
        e.setRightNode(g);
        b.setLeftNode(x);

        depthFirstTraversalPreOrder(a);
        System.out.println("\n---------------------");
        depthFirstTraversalInOrder(a);
        System.out.println("\n---------------------");
        depthFirstTraversalPostOrder(a);
        System.out.println("\n---------------------");
    }

    public static void depthFirstTraversalPreOrder(Node root){
        if(root == null){
            return;
        }
        print(root);
        depthFirstTraversalPreOrder(root.getLeftNode());
        depthFirstTraversalPreOrder(root.getRightNode());
    }

    public static void depthFirstTraversalInOrder(Node root){
        if(root == null){
            return;
        }
        depthFirstTraversalInOrder(root.getLeftNode());
        print(root);
        depthFirstTraversalInOrder(root.getRightNode());
    }

    public static void depthFirstTraversalPostOrder(Node root){
        if(root == null){
            return;
        }
        depthFirstTraversalPostOrder(root.getLeftNode());
        depthFirstTraversalPostOrder(root.getRightNode());
        print(root);
    }

    public static void print(Node node){
        System.out.print(node.getData() + " -> ");
    }

    public static class Node<T>{
        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data){
            this.data = data;
        }

        public T getData(){
            return this.data;
        }
        public void setLeftNode(Node<T> leftNode){
            this.leftNode = leftNode;
        }
        public Node<T> getLeftNode(){
            return this.leftNode;
        }
        public void setRightNode(Node<T> rightNode){
            this.rightNode = rightNode;
        }
        public Node<T> getRightNode(){
            return this.rightNode;
        }

    }

}
