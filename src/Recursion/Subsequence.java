import java.util.ArrayList;

public class Subsequence {

    public static void main(String[] args) {
        String str = "abc";
        printSubsequences( "",str);


        int count = countSubsequences(str);
        System.out.println("Total number of subsequences: " + count);

        ArrayList<String> result= subsequencesList("",str);
        System.out.println(result);
    }

    private static ArrayList<String> subsequencesList(String unprocess, String process) {
        if(process.isEmpty()){
            ArrayList<String>list = new ArrayList<>();
            list.add(unprocess);
            return  list;
        }

        char ch = process.charAt(0);

        ArrayList<String> left = subsequencesList((unprocess+ch), process.substring(1));
        ArrayList<String> right= subsequencesList(unprocess, process.substring(1));
       left.addAll(right);
        return  left;
    }

    private static void printSubsequences(String unprocess, String process) {
        if(process.isEmpty()){
            System.out.println(unprocess);
            return;
        }
        char ch = process.charAt(0);

         printSubsequences((unprocess+ch), process.substring(1));
         printSubsequences(unprocess, process.substring(1));
    }



    // Method to count the total number of subsequences using recursive approach
    static int countSubsequences(String str) {
        return countSubsequencesHelper(str, 0);
    }

    // Helper method to count subsequences recursively
    static int countSubsequencesHelper(String str, int index) {
        // Base case: if we have reached the end of the string, return 1 (the empty subsequence)
        if (index == str.length()) {
            return 1;
        }

        // Recursive case: for each character, we have two choices - include or exclude
        int exclude = countSubsequencesHelper(str, index + 1);    // Exclude the current character
        int include = countSubsequencesHelper(str, index + 1);    // Include the current character

        // Total subsequences = subsequences excluding current character + subsequences including current character
        return exclude + include;
    }

}
