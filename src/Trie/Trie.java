import java.util.Scanner;

public class Trie {
    private static final int CASE = 'a'; // Base character for indexing
    private static final int CAPACITY = 26; // Size of the alphabet (e.g., 26 for lowercase English letters)

    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            this.children = new TrieNode[CAPACITY]; // Fixed-size array for children
            this.isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - CASE; // Convert character to array index
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - CASE;
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    // Check if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - CASE;
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

    // Delete a word from the Trie
    public void delete(String word) {
        deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false; // Word not found
            }
            current.isEndOfWord = false;
            return isEmptyNode(current); // Check if the node has no children
        }

        char ch = word.charAt(index);
        int childIndex = ch - CASE;
        TrieNode node = current.children[childIndex];
        if (node == null) {
            return false; // Word not found
        }

        boolean shouldDeleteCurrentNode = deleteHelper(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.children[childIndex] = null; // Remove the reference to the child node
            return isEmptyNode(current); // Check if the node has no children
        }
        return false;
    }

    // Check if a node has no children
    private boolean isEmptyNode(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    // Display all words in the Trie
    public void display() {
        displayHelper(root, new StringBuilder());
    }

    private void displayHelper(TrieNode node, StringBuilder currentWord) {
        if (node.isEndOfWord) {
            System.out.println(currentWord.toString());
        }

        for (int i = 0; i < CAPACITY; i++) {
            if (node.children[i] != null) {
                currentWord.append((char) (CASE + i)); // Convert index back to character
                displayHelper(node.children[i], currentWord);
                currentWord.deleteCharAt(currentWord.length() - 1); // Backtrack
            }
        }
    }

    // Count the total number of words in the Trie
    public int countWords() {
        return countWordsHelper(root);
    }

    private int countWordsHelper(TrieNode node) {
        int count = 0;
        if (node.isEndOfWord) {
            count++;
        }
        for (TrieNode child : node.children) {
            if (child != null) {
                count += countWordsHelper(child);
            }
        }
        return count;
    }

    // Check if the Trie is empty
    public boolean isEmpty() {
        return isEmptyNode(root);
    }

    // Clear the Trie
    public void clear() {
        root.children = new TrieNode[CAPACITY]; // Reset the root's children
        System.out.println("Trie has been cleared.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();
        int option;
        String word;

        do {
            System.out.println("\nTrie Implementation:");
            System.out.println("1: Insert a word");
            System.out.println("2: Search for a word");
            System.out.println("3: Check if a prefix exists");
            System.out.println("4: Delete a word");
            System.out.println("5: Display all words");
            System.out.println("6: Count total words");
            System.out.println("7: Clear the Trie");
            System.out.println("0: Quit");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter word to insert: ");
                    word = sc.next();
                    trie.insert(word);
                    System.out.println("Word inserted.");
                    break;

                case 2:
                    System.out.print("Enter word to search: ");
                    word = sc.next();
                    boolean found = trie.search(word);
                    System.out.println("Word \"" + word + "\" " + (found ? "found in the Trie." : "not found in the Trie."));
                    break;

                case 3:
                    System.out.print("Enter prefix to check: ");
                    word = sc.next();
                    boolean prefixExists = trie.startsWith(word);
                    System.out.println("Prefix \"" + word + "\" " + (prefixExists ? "exists in the Trie." : "does not exist in the Trie."));
                    break;

                case 4:
                    System.out.print("Enter word to delete: ");
                    word = sc.next();
                    trie.delete(word);
                    System.out.println("Word \"" + word + "\" deleted (if it existed).");
                    break;

                case 5:
                    System.out.println("Words in the Trie:");
                    trie.display();
                    break;

                case 6:
                    System.out.println("Total number of words in the Trie: " + trie.countWords());
                    break;

                case 7:
                    trie.clear();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        } while (option != 0);
        sc.close();
    }
}