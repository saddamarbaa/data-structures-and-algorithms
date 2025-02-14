import java.util.ArrayList;
import java.util.Scanner;

public class MaxHeap {
    private ArrayList<Integer> heap;

    // Constructor to initialize the heap
    public MaxHeap() {
        this.heap = new ArrayList<>();
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
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    // Insert a new element into the heap
    public void insert(int value) {
        // Add the new element to the end of the ArrayList
        heap.add(value);

        // Heapify up to maintain the heap property
        heapifyUp(heap.size() - 1);
    }

    // Heapify up to maintain the heap property
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    // Extract the maximum element (root) from the heap
    public int extractMax() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty. Cannot extract maximum.");
            return Integer.MIN_VALUE;
        }

        // Store the maximum value (root)
        int max = heap.get(0);

        // Replace the root with the last element in the heap
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        // Heapify down to maintain the heap property
        if (!heap.isEmpty()) {
            heapifyDown(0);
        }

        return max;
    }

    // Heapify down to maintain the heap property
    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        // Find the largest among the current node and its children
        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        // If the largest is not the current node, swap and continue heapifying down
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Get the maximum element without removing it
    public int getMax() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty. No maximum element.");
            return Integer.MIN_VALUE;
        }
        return heap.get(0);
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Get the size of the heap
    public int getSize() {
        return heap.size();
    }

    // Print the heap
    public void printHeap() {
        System.out.print("Max-Heap: ");
        for (int value : heap) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Clear the heap
    public void clear() {
        heap.clear();
        System.out.println("Heap has been cleared.");
    }

    // Check if the heap is a valid max-heap
    public boolean isValidMaxHeap() {
        for (int i = 0; i <= parent(heap.size() - 1); i++) {
            int left = leftChild(i);
            int right = rightChild(i);

            if ((left < heap.size() && heap.get(left) > heap.get(i)) ||
                    (right < heap.size() && heap.get(right) > heap.get(i))) {
                return false;
            }
        }
        return true;
    }

    // Build a max-heap from an array
    public void buildHeap(int[] array) {
        // Clear the current heap
        heap.clear();

        // Add all elements from the array to the heap
        for (int value : array) {
            heap.add(value);
        }

        // Heapify all non-leaf nodes
        for (int i = parent(heap.size() - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // Heap sort (ascending order)
    public void heapSort() {
        ArrayList<Integer> sortedList = new ArrayList<>();
        while (!heap.isEmpty()) {
            sortedList.add(extractMax());
        }
        heap = sortedList;
    }

    // Override toString method to print heap details
    @Override
    public String toString() {
        return "Max-Heap: " + heap.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaxHeap maxHeap = new MaxHeap();
        int option, element;

        do {
            System.out.println("\nMax-Heap Implementation:");
            System.out.println("1: Insert element");
            System.out.println("2: Extract maximum element");
            System.out.println("3: Get maximum element");
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
                    maxHeap.insert(element);
                    break;

                case 2:
                    int max = maxHeap.extractMax();
                    if (max != Integer.MIN_VALUE) {
                        System.out.println("Extracted maximum element: " + max);
                    }
                    break;

                case 3:
                    System.out.println("Maximum element: " + maxHeap.getMax());
                    break;

                case 4:
                    maxHeap.printHeap();
                    break;

                case 5:
                    System.out.println("Heap is " + (maxHeap.isEmpty() ? "empty." : "not empty."));
                    break;

                case 6:
                    System.out.println("Heap size: " + maxHeap.getSize());
                    break;

                case 7:
                    maxHeap.clear();
                    break;

                case 8:
                    System.out.println("Heap is " + (maxHeap.isValidMaxHeap() ? "valid." : "not valid."));
                    break;

                case 9:
                    System.out.print("Enter the number of elements in the array: ");
                    int n = sc.nextInt();
                    int[] array = new int[n];
                    System.out.print("Enter the elements: ");
                    for (int i = 0; i < n; i++) {
                        array[i] = sc.nextInt();
                    }
                    maxHeap.buildHeap(array);
                    break;

                case 10:
                    maxHeap.heapSort();
                    System.out.println("Heap after sorting: " + maxHeap);
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