import java.util.Scanner;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the heap
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Get the index of the parent node
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Get the index of the left child node
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Get the index of the right child node
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Swap two elements in the heap
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    // Insert a new element into the heap
    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full. Cannot insert more elements.");
            return;
        }

        // Insert the new element at the end
        heap[size] = value;
        size++;

        // Heapify up to maintain the heap property
        heapifyUp(size - 1);
    }

    // Heapify up to maintain the heap property
    private void heapifyUp(int index) {
        while (index > 0 && heap[parent(index)] > heap[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    // Extract the minimum element (root) from the heap
    public int extractMin() {
        if (size <= 0) {
            System.out.println("Heap is empty. Cannot extract minimum.");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            size--;
            return heap[0];
        }

        // Store the minimum value and replace it with the last element
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // Heapify down to maintain the heap property
        heapifyDown(0);

        return min;
    }

    // Heapify down to maintain the heap property
    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        // Find the smallest among the current node and its children
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        // If the smallest is not the current node, swap and continue heapifying down
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Get the minimum element without removing it
    public int getMin() {
        if (size <= 0) {
            System.out.println("Heap is empty. No minimum element.");
            return Integer.MIN_VALUE;
        }
        return heap[0];
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the size of the heap
    public int getSize() {
        return size;
    }

    // Print the heap
    public void printHeap() {
        System.out.print("Heap: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Clear the heap
    public void clear() {
        size = 0;
        System.out.println("Heap has been cleared.");
    }

    // Check if the heap is a valid min-heap
    public boolean isValidMinHeap() {
        for (int i = 0; i <= parent(size - 1); i++) {
            int left = leftChild(i);
            int right = rightChild(i);

            if ((left < size && heap[left] < heap[i]) || (right < size && heap[right] < heap[i])) {
                return false;
            }
        }
        return true;
    }

    // Build a heap from an array
    public void buildHeap(int[] array) {
        if (array.length > capacity) {
            System.out.println("Array size exceeds heap capacity.");
            return;
        }

        // Copy the array into the heap
        System.arraycopy(array, 0, heap, 0, array.length);
        size = array.length;

        // Heapify all non-leaf nodes
        for (int i = parent(size - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // Heap sort
    public void heapSort() {
        int originalSize = size;
        for (int i = size - 1; i >= 0; i--) {
            swap(0, i);
            size--;
            heapifyDown(0);
        }
        size = originalSize;
    }

    // Override toString method to print heap details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Heap: ");
        for (int i = 0; i < size; i++) {
            sb.append(heap[i]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the capacity of the heap: ");
        int capacity = sc.nextInt();
        MinHeap minHeap = new MinHeap(capacity);
        int option, element;

        do {
            System.out.println("\nMin-Heap Implementation:");
            System.out.println("1: Insert element");
            System.out.println("2: Extract minimum element");
            System.out.println("3: Get minimum element");
            System.out.println("4: Print heap");
            System.out.println("5: Check if heap is empty");
            System.out.println("6: Get heap size");
            System.out.println("7: Clear heap");
            System.out.println("8: Check if heap is valid");
            System.out.println("9: Build heap from array");
            System.out.println("10: Perform heap sort");
            System.out.println("0: Quit");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    element = sc.nextInt();
                    minHeap.insert(element);
                    break;

                case 2:
                    int min = minHeap.extractMin();
                    if (min != Integer.MIN_VALUE) {
                        System.out.println("Extracted minimum element: " + min);
                    }
                    break;

                case 3:
                    System.out.println("Minimum element: " + minHeap.getMin());
                    break;

                case 4:
                    minHeap.printHeap();
                    break;

                case 5:
                    System.out.println("Heap is " + (minHeap.isEmpty() ? "empty." : "not empty."));
                    break;

                case 6:
                    System.out.println("Heap size: " + minHeap.getSize());
                    break;

                case 7:
                    minHeap.clear();
                    break;

                case 8:
                    System.out.println("Heap is " + (minHeap.isValidMinHeap() ? "valid." : "not valid."));
                    break;

                case 9:
                    System.out.print("Enter the number of elements in the array: ");
                    int n = sc.nextInt();
                    int[] array = new int[n];
                    System.out.print("Enter the elements: ");
                    for (int i = 0; i < n; i++) {
                        array[i] = sc.nextInt();
                    }
                    minHeap.buildHeap(array);
                    break;

                case 10:
                    minHeap.heapSort();
                    System.out.println("Heap after sorting: " + minHeap);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        } while (option != 0);
        sc.close();
    }
}