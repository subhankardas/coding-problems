package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumDeletionsMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        // System.out.println(minDeletions("aaabbbcc"));
        // System.out.println(minDeletions("ceabaacb"));
        System.out.println(minDeletions("bbcebab"));
    }

    public static int minDeletions(String s) {
        // Calculate character frequencies
        Map<Character, Integer> freq = new HashMap<>();
        for (int idx = 0; idx < s.length(); idx++) {
            freq.put(s.charAt(idx), freq.getOrDefault(s.charAt(idx), 0) + 1);
        }

        // Turn frequency map into set of unique count
        Set<Integer> uniqueFreq = new HashSet<>();
        int noOfDeletions = 0;
        for (Character ch : freq.keySet()) {
            if (uniqueFreq.contains(freq.get(ch))) { // Duplicate character frequency
                int nonUniqueFreq = freq.get(ch);
                while (uniqueFreq.contains(nonUniqueFreq) && nonUniqueFreq > 0) { // Subtract non unique frequency until
                                                                                  // it becomes unique
                    nonUniqueFreq--;
                    noOfDeletions++; // Increase deletions count every time
                }
                uniqueFreq.add(nonUniqueFreq); // Add final unique frequency, add to set
            } else {
                uniqueFreq.add(freq.get(ch)); // Already unique frequency, add to set
            }
        }
        return noOfDeletions;
    }
}
