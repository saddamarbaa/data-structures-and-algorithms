/*
1832. Check if the Sentence Is Pangram
Easy
Companies
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false
 

Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters.
*/

public class PangramChecker {
    
    public static boolean checkIfPangram(String sentence) {
        boolean[] letters = new boolean[26];  // initialize boolean array to track presence of each letter
        
        for (char c : sentence.toCharArray()) {
            if (c >= 'a' && c <= 'z') {  // check if character is a lowercase letter
                letters[c - 'a'] = true;  // mark letter as seen
            }
        }
        
        for (boolean present : letters) {
            if (!present) {  // check if any letter is missing
                return false;  // sentence is not a pangram
            }
        }
        
        return true;  // sentence is a pangram
    }
    
    public static void main(String[] args) {
        String sentence1 = "the quick brown fox jumps over the lazy dog";
        String sentence2 = "the quick brown fox jumps over the lazy cat";
        
        System.out.println("Sentence 1 is a pangram: " + checkIfPangram(sentence1));  // true
        System.out.println("Sentence 2 is a pangram: " + checkIfPangram(sentence2));  // false
    }
}
