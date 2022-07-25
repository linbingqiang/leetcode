package com.lbq.offer.solutions.trie;

/**
 *
 * 最短的单词编码
 *
 * 输入一个包含n个单词的数组，可以把它们编码成一个字符串和n个下标。
 * 例如，单词数组["time"，"me"，"bell"]可以编码成一个字符串"time＃bell＃"，然后这些单词就可以通过下标[0，2，5]得到。
 * 对于每个下标，都可以从编码得到的字符串中相应的位置开始扫描，直到遇到'＃'字符前所经过的子字符串为单词数组中的一个单词。
 * 例如，从"time＃bell＃"下标为2的位置开始扫描，直到遇到'＃'前经过子字符串"me"是给定单词数组的第2个单词。
 * 给定一个单词数组，请问按照上述规则把这些单词编码之后得到的最短字符串的长度是多少？如果输入的是字符串数组["time"，"me"，"bell"]，
 * 那么编码之后最短的字符串是"time＃bell＃"，长度是10。
 * 将数组中的单词翻转之后构造前缀树之后，在通过深度优先搜索遍历的方式即可
 *
 *                          []
 *                        /   \
 *                       e     l
 *                      /       \
 *                     m         l
 *                    /           \
 *                   i             e
 *                  /               \
 *                 t                 b
 * @author linbingqiang
 * @date 2022/7/25 11:02 PM
 */
public class ShortestWordEncoding {

    static StringBuilder res = new StringBuilder();

    public static void main(String[] args) {
        ShortestWordEncoding swe = new ShortestWordEncoding();
        String[] words = {"time", "me", "bell"};
        TrieNode root = swe.buildTrie(words);
        //递归
        StringBuilder path = new StringBuilder();
        swe.dfs(root, path);
        System.out.println(res.toString());

    }

    public int minimumLengthEncoding(String[] words) {
        return 0;
    }

    public void dfs(TrieNode root, StringBuilder path) {
        // 1.递归终止条件
        if (isLeaf(root)) {
            path.reverse();
            res.append(path).append("#");
            return;
        }
        for (int i = 0; i < root.getChildren().length; i++) {
            if (root.getChildren()[i] != null) {
                path.append((char)('a' + i));
                dfs(root.getChildren()[i], path);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public boolean isLeaf(TrieNode root) {
        if (root != null) {
            for (TrieNode node : root.getChildren()) {
                if (node != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (node.getChildren()[ch - 'a'] == null) {
                    node.getChildren()[ch - 'a'] = new TrieNode();
                }
                node = node.getChildren()[ch - 'a'];
            }
        }
        return root;
    }
}
