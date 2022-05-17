package com.mcartagena.datastructure.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contacts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            String operation = scan.next();
            String contact = scan.next();

            if (operation.equals("add")){
                trie.add(contact);

            } else if (operation.equals("find")){
                System.out.println(trie.find(contact));
            }
        }

        scan.close();

    }

    public static class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private int size = 0;

        public void addChildIfAbsent(char c) {
            children.putIfAbsent(c, new TrieNode());
        }

        public TrieNode getChild(char c) {
            return children.get(c);
        }

        public void addSize(int value) {
            this.size += value;
        }

        public int getSize() {
            return size;
        }
    }

    public static class Trie {
        private TrieNode root = new TrieNode();

        public void add(String word) {
            TrieNode curr = root;

            for (Character c : word.toCharArray()) {
                curr.addChildIfAbsent(c);
                curr = curr.getChild(c);
                curr.addSize(1);
            }
        }

        public int find(String prefix) {
            TrieNode curr = root;

            for(Character c: prefix.toCharArray()) {
                curr = curr.getChild(c);
                if(curr == null){
                    return 0;
                }
            }
            return curr.getSize();
        }
    }

}
