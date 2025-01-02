/**
 232. Implement Queue using Stacks
 Easy
 Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

 Implement the MyQueue class:

 void push(int x) Pushes element x to the back of the queue.
 int pop() Removes the element from the front of the queue and returns it.
 int peek() Returns the element at the front of the queue.
 boolean empty() Returns true if the queue is empty, false otherwise.
 Notes:

 You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.


 Example 1:

 Input
 ["MyQueue", "push", "push", "peek", "pop", "empty"]
 [[], [1], [2], [], [], []]
 Output
 [null, null, null, 1, 1, false]

 Explanation
 MyQueue myQueue = new MyQueue();
 myQueue.push(1); // queue is: [1]
 myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 myQueue.peek(); // return 1
 myQueue.pop(); // return 1, queue is [2]
 myQueue.empty(); // return false


 Constraints:

 1 <= x <= 9
 At most 100 calls will be made to push, pop, peek, and empty.
 All the calls to pop and peek are valid.


 Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity?
 In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack1; // Stack to handle the push operations
    private Stack<Integer> stack2; // Stack to handle the pop and peek operations

    public MyQueue() {
        this.stack1 = new Stack<>();
       this.stack2 = new Stack<>();
    }

    /**
     * Algorithm Steps for `push(x)`:
     * 1. Simply push the element x onto stack1.
     *
     * Time Complexity: O(1) - Pushing an element onto a stack is constant time.
     * Space Complexity: O(1) - No extra space used except for the input element.
     *
     * @param x - Element to be added to the queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Algorithm Steps for `pop()`:
     * 1. If stack2 is empty, transfer all elements from stack1 to stack2.
     *    - This reversal ensures that the oldest element in stack1 will be on top of stack2.
     * 2. Pop the element from stack2 (which is the front of the queue).
     *
     * Time Complexity: O(n) in the worst case (when transferring elements between stacks).
     * Space Complexity: O(1) - Space used by stack2 and stack1 is linear but constant extra space is used for the operation.
     *
     * @returns The front element of the queue.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop()); // Transfer elements to stack2
            }
        }
        return stack2.pop(); // Pop from stack2 which represents the front of the queue
    }

    /**
     * Algorithm Steps for `peek()`:
     * 1. If stack2 is empty, transfer all elements from stack1 to stack2.
     * 2. Return the top element of stack2 (which represents the front of the queue).
     *
     * Time Complexity: O(n) in the worst case (when transferring elements between stacks).
     * Space Complexity: O(1) - Constant extra space used.
     *
     * @returns The front element of the queue.
     */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop()); // Transfer elements to stack2
            }
        }
        return stack2.peek(); // Return the front of the queue
    }

    /**
     * Algorithm Steps for `empty()`:
     * 1. Return true if both stack1 and stack2 are empty.
     * 2. Otherwise, return false.
     *
     * Time Complexity: O(1) - Constant time for checking if both stacks are empty.
     * Space Complexity: O(1) - Constant extra space.
     *
     * @returns `true` if the queue is empty, `false` otherwise.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Test Case 1: Push and pop elements from the queue
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("Test Case 1 - Peek: " + queue.peek()); // Expected: 1
        System.out.println("Test Case 1 - Pop: " + queue.pop()); // Expected: 1
        System.out.println("Test Case 1 - Pop: " + queue.pop()); // Expected: 2

        // Test Case 2: Check if the queue is empty
        System.out.println("Test Case 2 - Is queue empty? " + queue.empty()); // Expected: false

        // Test Case 3: Peek and pop after emptying the queue
        queue.push(4);
        queue.push(5);
        System.out.println("Test Case 3 - Peek: " + queue.peek()); // Expected: 3
        System.out.println("Test Case 3 - Pop: " + queue.pop()); // Expected: 3
        System.out.println("Test Case 3 - Is queue empty? " + queue.empty()); // Expected: false
    }
}


class MyQueue2 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor to initialize the stacks
    public MyQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push element to the back of the queue
    public void push(int x) {
        stack1.push(x);  // Add element to stack1
    }

    // Pop the front element of the queue
    public int pop() {
        if (stack2.isEmpty()) {
            // Move all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Store the element popped from stack2 in a variable
        int front = stack2.pop();

        // Push everything back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        // Return the front element stored in 'front'
        return front;
    }

    // Get the front element of the queue without popping it
    public int peek() {
        if (stack2.isEmpty()) {
            // Move all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Store the front element (top of stack2) in a variable
        int front = stack2.peek();

        // Push everything back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        // Return the front element stored in 'front'
        return front;
    }

    // Check if the queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
