/**
 225. Implement Stack using Queues

 Easy
 Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

 Implement the MyStack class:

 void push(int x) Pushes element x to the top of the stack.
 int pop() Removes the element on the top of the stack and returns it.
 int top() Returns the element on the top of the stack.
 boolean empty() Returns true if the stack is empty, false otherwise.
 Notes:

 You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.


 Example 1:

 Input
 ["MyStack", "push", "push", "top", "pop", "empty"]
 [[], [1], [2], [], [], []]
 Output
 [null, null, null, 2, 2, false]

 Explanation
 MyStack myStack = new MyStack();
 myStack.push(1);
 myStack.push(2);
 myStack.top(); // return 2
 myStack.pop(); // return 2
 myStack.empty(); // return False


 Constraints:

 1 <= x <= 9
 At most 100 calls will be made to push, pop, top, and empty.
 All the calls to pop and top are valid.


 Follow-up: Can you implement the stack using only one queue?
 */

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue1;  // Main queue to hold elements
    private Queue<Integer> queue2;  // Temporary queue for assisting in push operation

    // Constructor to initialize the queues
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto the stack.
     * 1. Add the new element to queue2.
     * 2. Move all the elements from queue1 to queue2 (this reverses the order).
     * 3. Swap the names of queue1 and queue2 (queue1 will now have the new element on top).
     *
     * Time Complexity: O(n) where n is the number of elements in the queue.
     * Space Complexity: O(1) - Constant extra space for the operation.
     */
    public void push(int x) {
        queue2.add(x);  // Add the new element to queue2

        // Move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Swap the names of the two queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     * This operation simply removes the front element from queue1.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int pop() {
        return queue1.remove();
    }

    /**
     * Get the top element of the stack.
     * This operation retrieves the front element of queue1 without removing it.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     * This checks if queue1 is empty.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        // Test Case 1: Push elements and check the top
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: " + stack.top()); // Expected: 3

        // Test Case 2: Pop elements and check the stack
        System.out.println("Popped element: " + stack.pop()); // Expected: 3
        System.out.println("Top element: " + stack.top()); // Expected: 2

        // Test Case 3: Check if stack is empty
        System.out.println("Is stack empty? " + stack.empty()); // Expected: false

        stack.pop();
        stack.pop();
        System.out.println("Is stack empty after popping all? " + stack.empty()); // Expected: true
    }
}






//Follow-up: Can you implement the stack using only one queue?
class MyStack2 {

    private Queue<Integer> queue;

    public MyStack2() {
        this.queue = new LinkedList<>();
    }

    /**
     * Algorithm Steps for `push(x)`:
     * 1. Add the element x to the queue.
     * 2. Rotate the queue by moving all elements before x to the back.
     *    - This makes x the front of the queue (simulating stack behavior).
     *
     * Time Complexity: O(n) - Rotating the queue requires moving all previous elements.
     * Space Complexity: O(1) - Constant extra space used.
     *
     * @param x - Element to be added to the stack.
     */
    public void push(int x) {
        // Add the new element to the queue
        queue.offer(x);
        // Rotate the queue to move the newly added element to the front
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    /**
     * Algorithm Steps for `pop()`:
     * 1. Dequeue and return the front element of the queue.
     *
     * Time Complexity: O(1) - Dequeuing an element from the queue is constant time.
     * Space Complexity: O(1) - Constant extra space used.
     *
     * @returns The top element of the stack.
     */
    public int pop() {
        return queue.poll(); // Remove and return the front element
    }

    /**
     * Algorithm Steps for `top()`:
     * 1. Return the front element of the queue without removing it.
     *
     * Time Complexity: O(1) - Returning the front element is constant time.
     * Space Complexity: O(1) - Constant extra space used.
     *
     * @returns The top element of the stack.
     */
    public int top() {
        return queue.peek(); // Return the front element without removing it
    }

    /**
     * Algorithm Steps for `empty()`:
     * 1. Return true if the queue is empty, false otherwise.
     *
     * Time Complexity: O(1) - Checking if the queue is empty is constant time.
     * Space Complexity: O(1) - Constant extra space used.
     *
     * @returns `true` if the stack is empty, `false` otherwise.
     */
    public boolean empty() {
        return queue.isEmpty(); // Check if the queue is empty
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        // Test Case 1: Push and pop elements from the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Test Case 1 - Top: " + stack.top()); // Expected: 3
        System.out.println("Test Case 1 - Pop: " + stack.pop()); // Expected: 3
        System.out.println("Test Case 1 - Pop: " + stack.pop()); // Expected: 2

        // Test Case 2: Check if the stack is empty
        System.out.println("Test Case 2 - Is stack empty? " + stack.empty()); // Expected: false

        // Test Case 3: Peek and pop after emptying the stack
        stack.push(4);
        stack.push(5);
        System.out.println("Test Case 3 - Top: " + stack.top()); // Expected: 5
        System.out.println("Test Case 3 - Pop: " + stack.pop()); // Expected: 5
        System.out.println("Test Case 3 - Is stack empty? " + stack.empty()); // Expected: false
    }
}
