package leetcode.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Problem: In English, we have a concept called root, which can be followed by
 * some other word to form another longer word - let's call this word
 * derivative. For example, when the root "help" is followed by the word "ful",
 * we can form a derivative "helpful".
 * 
 * Given a dictionary consisting of many roots and a sentence consisting of
 * words separated by spaces, replace all the derivatives in the sentence with
 * the root forming it. If a derivative can be replaced by more than one root,
 * replace it with the root that has the shortest length.
 * 
 * Return the sentence after the replacement.
 * 
 * @author Subhankar Das
 */
public class LT_648_Replace_Words {

    public static void main(String[] args) {
        System.out.println(replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(replaceWordsTrie(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }

    /**
     * NAIVE SOLUTION
     * RUNTIME: 42 ms Beats 45.15% of users with Java
     * MEMORY: 51.58 MB Beats 98.11% of users with Java
     */
    public static String replaceWords(List<String> dictionary, String sentence) {
        Map<Integer, Set<String>> map = new HashMap<>();
        for (String s : dictionary) {
            map.putIfAbsent(s.length(), new HashSet<>());
            map.get(s.length()).add(s);
        }
        dictionary = null;
        System.gc();

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j < words[i].length(); j++) {
                if (map.containsKey(j) && map.get(j).contains(words[i].substring(0, j))) {
                    words[i] = words[i].substring(0, j);
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    /**
     * TRIE BASED SOLUTION
     * RUNTIME: 20 ms Beats 61.29% of users with Java
     * MEMORY: 55.50 MB Beats 39.98% of users with Java
     */
    public static String replaceWordsTrie(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word); // insert all dictionary words into trie
        }

        String[] words = sentence.split(" ");
        String matchPrefix = null;
        for (int i = 0; i < words.length; i++) {
            matchPrefix = trie.hasPrefix(words[i]); // check if the word exists in trie
            words[i] = matchPrefix != null ? matchPrefix : words[i]; // replace with longest prefix or keep the same
        }

        return String.join(" ", words);
    }
}
