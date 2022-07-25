package com.lbq.offer.solutions.trie;

public class TrieNode {

    private TrieNode[] children;

    private boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}
