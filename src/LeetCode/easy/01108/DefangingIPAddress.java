import java.util.*;

/**
 1108. Defanging an IP Address

 Easy

 Given a valid (IPv4) IP address, return a defanged version of that IP address.

 A defanged IP address replaces every period "." with "[.]".

 Example 1:

 Input: address = "1.1.1.1"
 Output: "1[.]1[.]1[.]1"

 Example 2:

 Input: address = "255.100.50.0"
 Output: "255[.]100[.]50[.]0"

 Constraints:

 The given address is a valid IPv4 address.
 */
public class DefangingIPAddress {
    public static void main(String[] args) {
        // Test case 1
        String address1 = "1.1.1.1";
        String expected1 = "1[.]1[.]1[.]1";
        String result1 = defangIPaddr(address1);
        runTestCase(address1, result1, expected1);

        // Test case 2
        String address2 = "255.100.50.0";
        String expected2 = "255[.]100[.]50[.]0";
        String result2 = defangIPaddr(address2);
        runTestCase(address2, result2, expected2);

        // Test case 3 using the third method
        String result3 = defangIPaddr3(address2);
        runTestCase(address2, result3, expected2);
    }

    /**
     * Helper function to execute a test case, compare expected vs actual, and print the results.
     *
     * @param address The input IP address.
     * @param result The actual result string returned by the function.
     * @param expected The expected output string.
     */
    private static void runTestCase(String address, String result, String expected) {
        System.out.println("Input: " + address);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + result);

        // Check if the result matches the expected output
        if (result.equals(expected)) {
            System.out.println("Test Result: PASS");
        } else {
            System.out.println("Test Result: FAIL");
        }
        System.out.println();
    }

    /**
     * Function to return a defanged version of an IP address using replace method.
     *
     * @param address The input IP address as a string.
     * @return The defanged IP address.
     */
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    /**
     * Alternative function to return a defanged version of an IP address using StringBuilder.
     *
     * @param address The input IP address as a string.
     * @return The defanged IP address.
     */
    public static String defangIPaddr2(String address) {
        StringBuilder defanged = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                defanged.append("[.]");
            } else {
                defanged.append(ch);
            }
        }
        return defanged.toString();
    }

    /**
     * Third function to return a defanged version of an IP address using a manual string approach.
     *
     * @param address The input IP address as a string.
     * @return The defanged IP address.
     */
    public static String defangIPaddr3(String address) {
        String s = "";

        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);
            if (ch == '.') {
                s = s + "[.]";
            } else {
                s = s + ch;
            }
        }
        return s;
    }
}
