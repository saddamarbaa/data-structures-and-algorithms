import java.util.HashMap;

/**
 146. LRU Cache

 Medium

 Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

 Implement the LRUCache class:

 LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 int get(int key) Return the value of the key if the key exists, otherwise return -1.
 void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 The functions get and put must each run in O(1) average time complexity.



 Example 1:

 Input
 ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 Output
 [null, null, null, 1, null, -1, null, -1, 3, 4]

 Explanation
 LRUCache lRUCache = new LRUCache(2);
 lRUCache.put(1, 1); // cache is {1=1}
 lRUCache.put(2, 2); // cache is {1=1, 2=2}
 lRUCache.get(1);    // return 1
 lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 lRUCache.get(2);    // returns -1 (not found)
 lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 lRUCache.get(1);    // return -1 (not found)
 lRUCache.get(3);    // return 3
 lRUCache.get(4);    // return 4
 */
public class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1); // Dummy head node for ease of operations
    Node tail = new Node(-1, -1); // Dummy tail node for ease of operations
    int cap; // Capacity of the LRU Cache
    HashMap<Integer, Node> map = new HashMap<>(); // HashMap to store key and node references

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // Add a node right after the head (most recently used position)
    private void addNode(Node newnode) {
        Node temp = head.next;

        newnode.next = temp;
        newnode.prev = head;

        head.next = newnode;
        temp.prev = newnode;
    }

    // Remove the given node from the doubly linked list
    private void deleteNode(Node delnode) {
        Node prevv = delnode.prev;
        Node nextt = delnode.next;

        prevv.next = nextt;
        nextt.prev = prevv;
    }

    // Get the value of the key if it exists in the cache, else return -1
    public int get(int key) {
        if (map.containsKey(key)) {
            Node resNode = map.get(key);
            int ans = resNode.val;

            // Move the accessed node to the most recently used position
            map.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            map.put(key, head.next);
            return ans;
        }
        return -1; // Key not found
    }

    // Put key-value pair into the cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // If the key exists, remove the old node
            Node curr = map.get(key);
            map.remove(key);
            deleteNode(curr);
        }

        if (map.size() == cap) {
            // If the cache is full, remove the least recently used node (before tail)
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        // Add the new key-value pair and mark it as most recently used
        addNode(new Node(key, value));
        map.put(key, head.next);
    }


    // Main method with test cases
    public static void main(String[] args) {
        // Test case 1
        LRUCache cache1 = new LRUCache(2);
        cache1.put(1, 1);
        cache1.put(2, 2);
        runTestCase(cache1, 1, 1); // cache hit
        cache1.put(3, 3);          // LRU key 2 should be evicted
        runTestCase(cache1, 2, -1); // cache miss
        cache1.put(4, 4);          // LRU key 1 should be evicted
        runTestCase(cache1, 1, -1); // cache miss
        runTestCase(cache1, 3, 3); // cache hit
        runTestCase(cache1, 4, 4); // cache hit

        // Test case 2
        LRUCache cache2 = new LRUCache(3);
        cache2.put(1, 10);
        cache2.put(2, 20);
        cache2.put(3, 30);
        runTestCase(cache2, 1, 10); // cache hit
        cache2.put(4, 40);          // LRU key 2 should be evicted
        runTestCase(cache2, 2, -1); // cache miss
        cache2.put(5, 50);          // LRU key 3 should be evicted
        runTestCase(cache2, 3, -1); // cache miss
        runTestCase(cache2, 4, 40); // cache hit
        runTestCase(cache2, 5, 50); // cache hit
    }

    // Helper function to test get operation and check the result
    private static void runTestCase(LRUCache cache, int key, int expected) {
        int result = cache.get(key);
        System.out.println("get(" + key + ") -> Expected: " + expected + ", Actual: " + result);
        if (result == expected) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        System.out.println();
    }
}
