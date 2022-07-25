package com.lbq.offer.solutions.trie;



import java.util.ArrayList;
import java.util.List;

/**
 * 英语中有一个概念叫词根。在词根后面加上若干字符就能拼出更长的单词。
 * 例如，"an"是一个词根，在它后面加上"other"就能得到另一个单词"another"。
 * 现在给定一个由词根组成的字典和一个英语句子，如果句子中的单词在字典中有它的词根，则用它的词根替换该单词；如果单词没有词根，则保留该单词。请输出替换后的句子。
 * 例如，如果词根字典包含字符串["cat"，"bat"，"rat"]，英语句子为"the cattle was rattled by the battery"，
 * 则替换之后的句子是"the cat was rat by the bat"
 * @author linbingqiang
 * @date 2022/7/24 11:22 PM
 */
public class ReplaceWords {

    public static void main(String[] args) {
        ReplaceWords rw = new ReplaceWords();
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");

        String sentence = "the cattle was rattled by the battery";
        String res = rw.replaceWords(dict, sentence);
        System.out.println(res);
    }

    /**
     * 查找前缀并替换
     * @param dict 字典
     * @param sentence 句子
     * @return
     */
    public String replaceWords(List<String> dict, String sentence) {
        // 1. 构造前缀树
        TrieNode root = buildTrie(dict);
        // 2. 遍历句子并查找
        StringBuilder res = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            String prefix = findPrefix(root, word);
            if ("".equals(prefix)) {
                //说明没有前缀，返回原单词
                res.append(word).append(" ");
            } else {
                res.append(prefix).append(" ");
            }
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }

    /**
     * 在前缀树中查找word的前缀
     * @param root 前缀树根节点
     * @param word 目标单词
     * @return 前缀
     */
    private String findPrefix(TrieNode root, String word) {
        TrieNode node = root;
        StringBuilder res = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (node.isWord() || node.getChildren()[ch - 'a'] == null) {
                //不存在
                break;
            }
            res.append(ch);
            node = node.getChildren()[ch - 'a'];
        }
        return node.isWord() ? res.toString() : "";
    }


    /**
     * 将字典构造成前缀树
     * @param dict 字典
     * @return 前缀树根节点
     */
    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.getChildren()[ch - 'a'] == null) {
                    node.getChildren()[ch - 'a'] = new TrieNode();
                }
                node = node.getChildren()[ch - 'a'];
            }
            node.setWord(true);
        }
        return root;
    }


}
