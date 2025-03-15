
/**
 208. Implement Trie (Prefix Tree)
 Solved
 Medium
 Topics
 Companies
 A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

 Implement the Trie class:

 Trie() Initializes the trie object.
 void insert(String word) Inserts the string word into the trie.
 boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


 Example 1:

 Input
 ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 Output
 [null, null, true, false, true, null, true]

 Explanation
 Trie trie = new Trie();
 trie.insert("apple");
 trie.search("apple");   // return True
 trie.search("app");     // return False
 trie.startsWith("app"); // return True
 trie.insert("app");
 trie.search("app");     // return True


 Constraints:

 1 <= word.length, prefix.length <= 2000
 word and prefix consist only of lowercase English letters.
 At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */


class Trie {
    private TrieNode root;

    public static void main(String[] args) {
        // Test Case 1
        Trie trie = new Trie();
        trie.insert("apple");
        boolean result1 = trie.search("apple");   // returns true
        boolean result2 = trie.search("app");     // returns false
        boolean result3 = trie.startsWith("app"); // returns true
        trie.insert("app");
        boolean result4 = trie.search("app");     // returns true

        // Output Test Results
        runTestCase("apple", result1, true);
        runTestCase("app", result2, false);
        runTestCase("app", result3, true);
        runTestCase("app", result4, true);
    }

    private static void runTestCase(String input, boolean result, boolean expected) {
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        System.out.println("Test passed: " + (result == expected));
        System.out.println();
    }

    public Trie() {
        root = new TrieNode(); // Initialize the root node
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Calculate index in the array (0-25 for 'a'-'z')
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // Create a new node if it doesn't exist
            }
            node = node.children[index]; // Move to the next node
        }
        node.isEndOfWord = true; // Mark the end of the word
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord; // Check if the node is valid and marks the end of a word
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null; // Check if the prefix exists in the trie
    }

    // Helper method to search for a prefix or whole word in the trie
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Calculate index for each character
            if (node.children[index] == null) {
                return null; // If the node doesn't exist, return null
            }
            node = node.children[index]; // Move to the next node
        }
        return node;
    }

    // Trie Node definition using an array for children nodes
    private static class TrieNode {
        private TrieNode[] children; // Array of 26 children nodes (for 26 lowercase letters)
        private boolean isEndOfWord; // Marks if the node is the end of a word

        public TrieNode() {
            children = new TrieNode[26]; // Initialize the array for children nodes
            isEndOfWord = false; // Initially, it's not the end of a word
        }
    }
}
