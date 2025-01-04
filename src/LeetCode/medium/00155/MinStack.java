/**
 * 155. Min Stack
 * Medium
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 * - MinStack() initializes the stack object.
 * - void push(int val) pushes the element val onto the stack.
 * - void pop() removes the element on the top of the stack.
 * - int top() gets the top element of the stack.
 * - int getMin() retrieves the minimum element in the stack.
 *
 * You must implement a solution with O(1) time complexity for each function.
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 * Constraints:
 * - -2^31 <= val <= 2^31 - 1
 * - Methods pop, top and getMin operations will always be called on non-empty stacks.
 * - At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
 */

import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack;   // Stack to store all elements
    private Stack<Integer> minStack;    // Stack to store the minimum values

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        mainStack.push(value);

        // If the minStack is empty, push the value
        // Or, push the minimum of the top of minStack and the current value
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            int currentMin = minStack.peek();
            minStack.push(Math.min(currentMin, value));
        }
    }

    public void pop() {
        // Remove the top element from both stacks
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        // Return the top element of the main stack
        return mainStack.peek();
    }

    public int getMin() {
        // Return the top element of the minStack which is the minimum value
        return minStack.peek();
    }


    // if we use only one stack
    public int getMin2() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Loop through the stack to find the minimum value
        int min = mainStack.peek();  // Assume top element is the minimum initially
        for (int i : mainStack) {
            if (i < min) {
                min = i;  // Update min if a smaller value is found
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        System.out.println("Test Case 1 - Pushing values -2, 0, -3");
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Test Case 1 - Expected getMin: -3");
        System.out.println("Test Case 1 - Actual getMin: " + minStack.getMin());

        minStack.pop();
        System.out.println("Test Case 1 - After popping, Expected top: 0");
        System.out.println("Test Case 1 - Actual top: " + minStack.top());
        System.out.println("Test Case 1 - Expected getMin after pop: -2");
        System.out.println("Test Case 1 - Actual getMin after pop: " + minStack.getMin());

        // Add more test cases if needed
    }
}

/**
 * MinStack class implementation to perform stack operations while keeping track of the minimum value in constant time.
 *
 * Algorithm:
 * 1. Use two stacks:
 *    - One to store the actual elements.
 *    - Another to store the minimum value at each level of the stack.
 * 2. For each push operation, add the value to the stack and update the minStack if the value is less than or equal to the current minimum.
 * 3. For each pop operation, if the value popped from the main stack is equal to the current minimum, also pop the minStack.
 *
 * Time Complexity: O(1) for all operations (push, pop, top, getMin).
 * Space Complexity: O(n), where n is the number of elements in the stack.
 */
