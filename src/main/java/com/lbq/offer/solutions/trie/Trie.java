package com.lbq.offer.solutions.trie;

public class Trie {

    /**
     * 前缀树根节点
     */
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || "".equals(word)) {
            return;
        }
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            // 如果当前节点中不存在对应字符的子节点
            if (node.getChildren()[ch - 'a'] == null) {
                node.getChildren()[ch - 'a'] = new TrieNode();
            }
            node = node.getChildren()[ch - 'a'];
        }
        //最后一个字符设置为true
        node.setWord(true);
    }

    public boolean search(String word) {
        if (word == null || "".equals(word)) {
            return false;
        }
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.getChildren()[ch - 'a'] == null) {
                return false;
            }
            node = node.getChildren()[ch - 'a'];
        }
        return node.isWord();
    }

    public boolean startsWith(String word) {
        if (word == null || "".equals(word)) {
            return false;
        }
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.getChildren()[ch - 'a'] == null) {
                return false;
            }
            node = node.getChildren()[ch - 'a'];
        }
        return true;
    }

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        //insert boy
        trie.insert("boy");
        trie.insert("boss");
        trie.insert("cowboy");
        // search
        System.out.println("search boy: " + trie.search("boy"));
        System.out.println("search boss: " + trie.search("boss"));
        System.out.println("search cow: " + trie.search("cow"));
        // startsWith
        System.out.println("startsWith cow: " + trie.startsWith("cow"));

    }
}
