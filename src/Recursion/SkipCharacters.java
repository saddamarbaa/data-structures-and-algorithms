public class SkipCharacters {

    public static void main(String[] args) {
        String str1 = "AppleAndAardvark";
        String str2 = "AnAappleAdmirer";
        String str3 = "appetizer app applet apple appliance";

        System.out.println("Skipping 'apple': " + skipApple(str2));
        System.out.println("Skipping 'A': " + skipChar(str1, 'A'));
        System.out.println("Skipping 'a': " + skipChar(str2, 'a'));
        System.out.println("Skipping 'test': " + skipWord("this is a test string test test", "test"));
        System.out.println("Skipping 'app' but not 'apple': " + skipAppNotApple(str3));
    }

    // Generalized function to skip a specific character
    public static String skipChar(String str, char skipChar) {
        if (str.isEmpty()) {
            return "";
        }
        char currentChar = str.charAt(0);
        if (currentChar == skipChar) {
            return skipChar(str.substring(1), skipChar);  // Skip the current character
        }
        return currentChar + skipChar(str.substring(1), skipChar);  // Include the current character
    }

    // Function to skip the substring "apple"
    public static String skipApple(String str) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith("apple")) {
            return skipApple(str.substring(5));  // Skip the "apple" substring
        }
        return str.charAt(0) + skipApple(str.substring(1));  // Include the current character
    }

    // Function to skip any specific word
    public static String skipWord(String str, String wordToSkip) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith(wordToSkip)) {
            return skipWord(str.substring(wordToSkip.length()), wordToSkip);  // Skip the specified word
        }
        return str.charAt(0) + skipWord(str.substring(1), wordToSkip);  // Include the current character
    }

    // Function to skip any word that starts with "app" but not "apple"
    public static String skipAppNotApple(String str) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith("app") && !str.startsWith("apple")) {
            // Skip the word that starts with "app" but isn't "apple"
            int index = findFirstNonAlphabeticChar(str);
            return skipAppNotApple(str.substring(index));
        }
        return str.charAt(0) + skipAppNotApple(str.substring(1));  // Include the current character
    }

    // Helper function to find the index of the first non-alphabetic character (like a space or punctuation)
    private static int findFirstNonAlphabeticChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return i;  // Return the index of the first non-alphabetic character
            }
        }
        return str.length();  // If no non-alphabetic character is found, return the string length
    }
}
