/***
 49. Group Anagrams
 Medium
 Given an array of strings strs, group the
 anagrams
 together. You can return the answer in any order.

 Example 1:

 Input: strs = ["eat","tea","tan","ate","nat","bat"]

 Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

 Explanation:

 There is no string in strs that can be rearranged to form "bat".
 The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 Example 2:

 Input: strs = [""]

 Output: [[""]]

 Example 3:

 Input: strs = ["a"]

 Output: [["a"]]


 Constraints:

 1 <= strs.length <= 104
 0 <= strs[i].length <= 100
 strs[i] consists of lowercase English letters.
 */

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        // Test cases for checking Group Anagrams
        testGroupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                Arrays.asList(Arrays.asList("eat", "tea", "ate"), Arrays.asList("tan", "nat"), Arrays.asList("bat")));

        testGroupAnagrams(new String[]{"", ""},
                Arrays.asList(Arrays.asList("", "")));

        testGroupAnagrams(new String[]{"a"},
                Arrays.asList(Arrays.asList("a")));

        testGroupAnagrams(new String[]{"abc", "cba", "bca", "xyz", "yzx"},
                Arrays.asList(Arrays.asList("abc", "cba", "bca"), Arrays.asList("xyz", "yzx")));

        testGroupAnagrams(new String[]{"aaa", "aaa", "bbb", "ccc", "ccc"},
                Arrays.asList(Arrays.asList("aaa", "aaa"), Arrays.asList("bbb"), Arrays.asList("ccc", "ccc")));
    }

    /**
     * Method to test the Group Anagrams function.
     *
     * @param strs     The array of strings.
     * @param expected The expected grouped anagrams list.
     */
    public static void testGroupAnagrams(String[] strs, List<List<String>> expected) {
        List<List<String>> result = groupAnagrams(strs);
        System.out.println("Input: " + Arrays.toString(strs));
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        System.out.println("Test passed: " + compareAnagramGroups(result, expected));
        System.out.println();
    }

    /**
     * Method to find grouped anagrams.
     *
     * @param strs The array of strings.
     * @return The list of grouped anagrams.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Create a result list to store the final grouped anagrams
        List<List<String>> ans = new ArrayList<>();

        // Create a HashMap where the key is the sorted string, and the value is the list of anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String str : strs) {
            // Convert the string to a character array and sort it to form the key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);  // The sorted version of the string

            // Get the existing list for this sorted key, or create a new one if it doesn't exist
            List<String> tempList = map.getOrDefault(sorted, new ArrayList<>());

            // Add the original string to this list
            tempList.add(str);

            // Update the map with the updated list of anagrams
            map.put(sorted, tempList);
        }

        // Add all the lists of anagrams from the map to the final result list
        ans.addAll(map.values());

        // Return the list of grouped anagrams
        return ans;
    }

    /**
     * Utility method to compare two lists of lists to see if they have the same anagrams grouped.
     *
     * @param result   The result list of grouped anagrams.
     * @param expected The expected list of grouped anagrams.
     * @return True if both lists contain the same groups, false otherwise.
     */
    public static boolean compareAnagramGroups(List<List<String>> result, List<List<String>> expected) {
        if (result.size() != expected.size()) {
            return false;
        }
        for (List<String> list : result) {
            Collections.sort(list);
        }
        for (List<String> list : expected) {
            Collections.sort(list);
        }
        result.sort(Comparator.comparing(Object::toString));
        expected.sort(Comparator.comparing(Object::toString));
        return result.equals(expected);
    }
}
