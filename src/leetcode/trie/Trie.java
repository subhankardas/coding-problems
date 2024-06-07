package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }

}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int idx = 0; idx < word.length(); idx++) {
            char ch = word.charAt(idx);
            if (!node.children.containsKey(ch)) { // current node does not have the character
                node.children.put(ch, new TrieNode()); // create new node for the character
            }
            node = node.children.get(ch); // current node has the character, move to its children
        }
        node.isEndOfWord = true; // the last node is the end of the word
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int idx = 0; idx < word.length(); idx++) {
            char ch = word.charAt(idx);
            if (!node.children.containsKey(ch)) { // current node does not have the character
                return false;
            }
            node = node.children.get(ch); // current node has the character, move to its children
        }
        return node.isEndOfWord; // found the word at the last node
    }

    public String hasPrefix(String word) {
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < word.length(); idx++) {
            char ch = word.charAt(idx);
            node = node.children.get(ch); // current node has the character, move to its children

            sb.append(ch); // append the character to the prefix
            if (node == null) {
                return null; // the prefix does not exist
            }
            if (node.isEndOfWord) {
                return sb.toString(); // found the prefix at the last node
            }
        }
        return null; // the prefix does not exist
    }

}
