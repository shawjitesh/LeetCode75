package Trie;

/**
 * Represents a node in a Trie (prefix tree) data structure.
 * Each node contains an array of child nodes (one for each lowercase letter)
 * and a flag indicating whether this node marks the end of a word.
 */
public class TrieNode {
    /** 
     * Array of child nodes, one for each of the 26 lowercase letters (a-z).
     * Index 0 represents 'a', index 1 represents 'b', and so on.
     */
    TrieNode[] children;
    
    /** 
     * Flag indicating whether this node represents the end of a complete word.
     * Set to true when a word inserted into the trie ends at this node.
     */
    boolean isEndOfWord;
    
    /**
     * Constructs a new TrieNode with an empty array of children
     * and isEndOfWord set to false.
     */
    public TrieNode() {
        children = new TrieNode[26]; // 26 lowercase letters
        isEndOfWord = false;
    }
}

