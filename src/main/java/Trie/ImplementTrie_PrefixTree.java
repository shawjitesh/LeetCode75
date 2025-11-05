package Trie;

/**
 * A Trie (pronounced as "try") or prefix tree is a tree data structure used to 
 * efficiently store and retrieve keys in a dataset of strings. This implementation
 * supports efficient prefix matching and word searching operations.
 * 
 * <p>Applications of Trie include:
 * <ul>
 *   <li>Autocomplete functionality in search engines</li>
 *   <li>Spell checkers and spell correction</li>
 *   <li>IP routing (longest prefix matching)</li>
 *   <li>Predictive text input</li>
 * </ul>
 * 
 * <p>Time Complexity:
 * <ul>
 *   <li>Insert: O(m) where m is the length of the word</li>
 *   <li>Search: O(m) where m is the length of the word</li>
 *   <li>startsWith: O(m) where m is the length of the prefix</li>
 * </ul>
 * 
 * <p>Space Complexity: O(ALPHABET_SIZE * N * M) where N is the number of words
 * and M is the average length of words.
 */
public class ImplementTrie_PrefixTree {
    
    /** Root node of the trie. All words are inserted starting from this node. */
    private TrieNode root;
    
    /**
     * Initializes the trie object with an empty root node.
     */
    public ImplementTrie_PrefixTree() {
        root = new TrieNode();
    }
    
    /**
     * Inserts a word into the trie.
     * Traverses the trie character by character, creating new nodes as needed,
     * and marks the final node as the end of a word.
     * 
     * @param word The string to insert into the trie. Must contain only lowercase letters.
     * @throws IllegalArgumentException if word is null
     */
    public void insert(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word cannot be null");
        }
        
        TrieNode current = root;
        // Traverse each character in the word
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            // Create a new node if the path doesn't exist
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            // Move to the next node
            current = current.children[index];
        }
        // Mark the end of the word
        current.isEndOfWord = true;
    }
    
    /**
     * Searches for a complete word in the trie.
     * Returns true only if the word exists and was previously inserted.
     * 
     * @param word The string to search for. Must contain only lowercase letters.
     * @return true if the word exists in the trie, false otherwise
     */
    public boolean search(String word) {
        TrieNode node = findNode(word);
        // Word exists only if all characters are found AND it's marked as end of word
        return node != null && node.isEndOfWord;
    }
    
    /**
     * Checks if there is any previously inserted word that starts with the given prefix.
     * This is useful for autocomplete and prefix matching functionality.
     * 
     * @param prefix The prefix to search for. Must contain only lowercase letters.
     * @return true if there is any word with the given prefix, false otherwise
     */
    public boolean startsWith(String prefix) {
        TrieNode node = findNode(prefix);
        // Prefix exists if all characters are found (regardless of end-of-word flag)
        return node != null;
    }
    
    /**
     * Helper method to find the node corresponding to a given prefix or word.
     * Traverses the trie following the characters in the prefix.
     * 
     * @param prefix The prefix or word to search for in the trie
     * @return The TrieNode at the end of the prefix path, or null if the path doesn't exist
     */
    private TrieNode findNode(String prefix) {
        if (prefix == null) {
            return null;
        }
        
        TrieNode current = root;
        // Traverse each character in the prefix
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            // If any character is missing, the prefix doesn't exist
            if (current.children[index] == null) {
                return null;
            }
            // Move to the next node
            current = current.children[index];
        }
        return current;
    }

    /**
     * Main method for testing the Trie implementation.
     * Demonstrates basic operations: insert, search, and startsWith.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        ImplementTrie_PrefixTree trie = new ImplementTrie_PrefixTree();
        
        // Insert "apple"
        trie.insert("apple");
        System.out.println("Search 'apple': " + trie.search("apple"));   // true
        
        // Search for "app" (not inserted as a word yet)
        System.out.println("Search 'app': " + trie.search("app"));       // false
        
        // Check if any word starts with "app"
        System.out.println("Starts with 'app': " + trie.startsWith("app")); // true
        
        // Insert "app" as a word
        trie.insert("app");
        System.out.println("Search 'app': " + trie.search("app"));      // true
    }
    
}
