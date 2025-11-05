package Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Search Suggestions System
 * 
 * Design a system that suggests at most three product names from products 
 * after each character of searchWord is typed. Suggested products should have 
 * common prefix with searchWord. If there are more than three products with 
 * a common prefix return the three lexicographically minimums products.
 * 
 * Approach:
 * 1. Build a Trie from the products array
 * 2. For each prefix of searchWord, find all words starting with that prefix
 * 3. Sort the words lexicographically and return the first 3
 * 
 * Time Complexity: O(N * M + S * (M + K)) where:
 *   - N is the number of products
 *   - M is the average length of products
 *   - S is the length of searchWord
 *   - K is the number of words found (limited to 3)
 * 
 * Space Complexity: O(N * M) for the trie
 */
public class SearchSuggestionsSystem {
    
    private TrieNode root;
    
    /**
     * Builds a trie from the products array and returns suggestions for each prefix.
     * 
     * @param products Array of product names
     * @param searchWord The search word being typed
     * @return List of lists, where each inner list contains at most 3 suggestions
     *         for the corresponding prefix of searchWord
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Build the trie
        root = new TrieNode();
        for (String product : products) {
            insert(product);
        }
        
        List<List<String>> result = new ArrayList<>();
        
        // For each prefix of searchWord, find suggestions
        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            List<String> suggestions = getSuggestions(prefix);
            result.add(suggestions);
        }
        
        return result;
    }
    
    /**
     * Inserts a word into the trie.
     */
    private void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    /**
     * Gets at most 3 lexicographically smallest suggestions for a given prefix.
     * 
     * @param prefix The prefix to search for
     * @return List of at most 3 suggestions
     */
    private List<String> getSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();
        
        // Navigate to the node corresponding to the prefix
        TrieNode node = findNode(prefix);
        if (node == null) {
            return suggestions; // No words with this prefix
        }
        
        // Perform DFS to collect words, but stop after finding 3
        dfs(node, prefix, suggestions);
        
        return suggestions;
    }
    
    /**
     * Finds the node corresponding to a prefix in the trie.
     */
    private TrieNode findNode(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }
    
    /**
     * Performs DFS to collect words starting from the given node.
     * Stops after collecting 3 words to optimize performance.
     * 
     * @param node Current node in the trie
     * @param currentWord Current word being built
     * @param suggestions List to collect suggestions (max 3)
     */
    private void dfs(TrieNode node, String currentWord, List<String> suggestions) {
        // Stop if we already have 3 suggestions
        if (suggestions.size() >= 3) {
            return;
        }
        
        // If this node marks the end of a word, add it to suggestions
        if (node.isEndOfWord) {
            suggestions.add(currentWord);
        }
        
        // Explore children in lexicographical order (a-z)
        for (int i = 0; i < 26 && suggestions.size() < 3; i++) {
            if (node.children[i] != null) {
                char nextChar = (char) ('a' + i);
                dfs(node.children[i], currentWord + nextChar, suggestions);
            }
        }
    }

    /**
     * Main method for testing the implementation.
     */
    public static void main(String[] args) {
        SearchSuggestionsSystem solution = new SearchSuggestionsSystem();
        
        // Example 1
        String[] products1 = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord1 = "mouse";
        List<List<String>> result1 = solution.suggestedProducts(products1, searchWord1);
        System.out.println("Example 1:");
        for (List<String> suggestions : result1) {
            System.out.println(suggestions);
        }
        // Expected: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],
        //            ["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
        
        // Example 2
        String[] products2 = {"havana"};
        String searchWord2 = "havana";
        List<List<String>> result2 = solution.suggestedProducts(products2, searchWord2);
        System.out.println("\nExample 2:");
        for (List<String> suggestions : result2) {
            System.out.println(suggestions);
        }
        // Expected: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
    }
}
