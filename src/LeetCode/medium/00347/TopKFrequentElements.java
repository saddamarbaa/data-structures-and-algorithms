/***
 347. Top K Frequent Elements

 Medium

 Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 Example 1:

 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]
 Example 2:

 Input: nums = [1], k = 1
 Output: [1]


 Constraints:

 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
 k is in the range [1, the number of unique elements in the array].
 It is guaranteed that the answer is unique.


 Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.*;

public class TopKFrequentElements {

    /**
     * Function to return the k most frequent elements.
     *
     * @param nums the input array of integers
     * @param k the number of top frequent elements to return
     * @return a list of the k most frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element in the array using a HashMap.
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a priority queue (min-heap) to keep track of the top k frequent elements.
        // The heap stores entries in the form of (element, frequency), and it's ordered by frequency.
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // Step 3: Iterate over the frequency map, and for each entry, push it into the heap.
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            heap.offer(entry);
            // If the heap size exceeds k, remove the element with the lowest frequency.
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Step 4: Extract the elements from the heap to form the result.
        int[] result = new int[k];
        int index = 0;
        while (!heap.isEmpty()) {
            result[index++] = heap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(solution.topKFrequent(nums1, k1))); // Output: [1, 2]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(solution.topKFrequent(nums2, k2))); // Output: [1]
    }
}
