/**
 * 622. Design Circular Queue
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 *
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
 *
 * Your implementation should support the following operations:
 *
 * MyCircularQueue(k): Constructor, set the size of the queue to be k.
 * Front: Get the front item from the queue. If the queue is empty, return -1.
 * Rear: Get the last item from the queue. If the queue is empty, return -1.
 * enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
 * deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
 * isEmpty(): Checks whether the circular queue is empty or not.
 * isFull(): Checks whether the circular queue is full or not.
 *
 * Example:
 *
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
 * circularQueue.enQueue(1);  // return true
 * circularQueue.enQueue(2);  // return true
 * circularQueue.enQueue(3);  // return true
 * circularQueue.enQueue(4);  // return false, the queue is full
 * circularQueue.Rear();  // return 3
 * circularQueue.isFull();  // return true
 * circularQueue.deQueue();  // return true
 * circularQueue.enQueue(4);  // return true
 * circularQueue.Rear();  // return 4
 */

public class DesignCircularQueue {

    public static void main(String[] args) {
        // Test Case 1
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println("Enqueue 1: " + circularQueue.enQueue(1)); // true
        System.out.println("Enqueue 2: " + circularQueue.enQueue(2)); // true
        System.out.println("Enqueue 3: " + circularQueue.enQueue(3)); // true
        System.out.println("Enqueue 4: " + circularQueue.enQueue(4)); // false
        System.out.println("Rear: " + circularQueue.Rear()); // 3
        System.out.println("Is Full: " + circularQueue.isFull()); // true
        System.out.println("Dequeue: " + circularQueue.deQueue()); // true
        System.out.println("Enqueue 4: " + circularQueue.enQueue(4)); // true
        System.out.println("Rear: " + circularQueue.Rear()); // 4
    }

    static class MyCircularQueue {
        private int[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        /**
         * Constructor, set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            this.queue = new int[k];
            this.front = -1;
            this.rear = -1;
            this.size = 0;
            this.capacity = k;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            size--;
            return true;
        }

        /**
         * Get the front item from the queue. If the queue is empty, return -1.
         */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[front];
        }

        /**
         * Get the last item from the queue. If the queue is empty, return -1.
         */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return queue[rear];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return size == capacity;
        }
    }
}