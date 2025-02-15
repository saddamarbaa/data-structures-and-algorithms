import java.util.*;

/**
 * 1352. Product of the Last K Numbers
 *
 * Medium
 *
 * Implement the class ProductOfNumbers that supports two methods:
 *
 * 1. add(int num): Appends the number num to the list of numbers.
 * 2. getProduct(int k): Returns the product of the last k numbers in the list.
 *
 * You can assume that always the product will be non-negative.
 *
 * Example:
 *
 * Input:
 * ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
 * [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
 *
 * Output:
 * [null,null,null,null,null,null,20,40,0,null,32]
 *
 * Explanation:
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3);        // [3]
 * productOfNumbers.add(0);        // [3,0]
 * productOfNumbers.add(2);        // [3,0,2]
 * productOfNumbers.add(5);        // [3,0,2,5]
 * productOfNumbers.add(4);        // [3,0,2,5,4]
 * productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
 * productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
 * productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
 * productOfNumbers.add(8);        // [3,0,2,5,4,8]
 * productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32
 *
 * Constraints:
 * - There will be at most 4 * 10^4 calls to add and getProduct.
 * - 0 <= num <= 100
 * - 1 <= k <= 40000
 * - The product of the last k numbers is guaranteed to fit within a 32-bit integer.
 */

public class ProductOfNumbers {
    private List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);  // Initialize with 1 as a starting point for the product calculation.
    }

    /**
     * Add the number to the list of numbers.
     * If the number is 0, we reset the prefixProduct list to handle the reset of the product.
     * Otherwise, we calculate the new prefix product by multiplying the last product by the new number.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(n), where n is the number of elements added.
     *
     * @param num The number to add.
     */
    public void add(int num) {
        if (num == 0) {
            prefixProduct.clear();
            prefixProduct.add(1); // Reset the product list to handle 0 correctly.
        } else {
            int lastProduct = prefixProduct.get(prefixProduct.size() - 1);
            prefixProduct.add(lastProduct * num);
        }
    }

    /**
     * Get the product of the last k numbers.
     * If the number of elements in the prefixProduct list is less than k+1, it means a zero was added
     * during that time, and the product will be 0. Otherwise, we calculate the product by dividing
     * the cumulative product of all numbers by the cumulative product of the first (n-k) numbers.
     *
     * Time Complexity: O(1)
     *
     * @param k The number of last elements to get the product from.
     * @return The product of the last k numbers.
     */
    public int getProduct(int k) {
        int size = prefixProduct.size();
        if (k >= size) {
            return 0; // A zero has been encountered in the last k numbers.
        }
        return prefixProduct.get(size - 1) / prefixProduct.get(size - 1 - k);
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();

        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3, 0]
        productOfNumbers.add(2);        // [3, 0, 2]
        productOfNumbers.add(5);        // [3, 0, 2, 5]
        productOfNumbers.add(4);        // [3, 0, 2, 5, 4]

        System.out.println(productOfNumbers.getProduct(2)); // Output: 20
        System.out.println(productOfNumbers.getProduct(3)); // Output: 40
        System.out.println(productOfNumbers.getProduct(4)); // Output: 0

        productOfNumbers.add(8);        // [3, 0, 2, 5, 4, 8]
        System.out.println(productOfNumbers.getProduct(2)); // Output: 32
    }
}
