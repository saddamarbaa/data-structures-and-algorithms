import java.util.Scanner;

public class  InsertionSort  {
    private static final String ARRAY_SIZE_PROMPT = "Enter the size of the input array (or -1 to exit): ";
    private static final String ARRAY_ELEMENT_PROMPT = "Enter element %d of the array: ";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = getInputArraySize(scanner);
            if (size <= 0) {
                return;
            }
            int[] inputArray = new int[size];
            for (int i = 0; i < size; i++) {
                int currentElement = getInputArrayElement(scanner, i + 1);
                inputArray[i] = currentElement;
            }
            System.out.print("Unsorted input array: ");
            printArray(inputArray);
            sort(inputArray);
            System.out.print("Sorted array: ");
            printArray(inputArray);
        }
    }

    public static int getInputArraySize(Scanner scanner) {
        int size = 0;
        do {
            System.out.print(ARRAY_SIZE_PROMPT);
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                return -1;
            }
            try {
                size = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a positive integer or -1 to exit.");
            }
            if (size <= 0) {
                System.out.println("Error: Array size must be greater than zero. Please try again or enter -1 to exit.");
            }
        } while (size <= 0);
        return size;
    }

    public static int getInputArrayElement(Scanner scanner, int elementNumber) {
        int currentElement = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.printf(ARRAY_ELEMENT_PROMPT, elementNumber);
            String input = scanner.nextLine();
            try {
                currentElement = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter an integer");
            }
        }
        return currentElement;
    }


    /**
     * Insertion sort
     * Insertion sort algorithm is very a simple sorting that works
     * similar to the way we play card game. We split the array into 2 parts:
     * a sorted part and an unsorted part. We pick a value from the unsorted part
     * and place it in the right place in the sorted part.
     * <p>
     * How Insertion Sort Works?
     * (1) We assume the first element in the array is sorted.
     * (2) Start iterating over the array to be sorted from the second element
     * until the end of the array.
     * (3) Take the second element and store it separately in a temp variable.
     * (3) Compare temp with the first element. If the first element is greater than temp,
     * then temp is placed in front of the first element.
     * (4) Now, the first two elements are sorted.
     * (5) Take the third element and compare it with the elements on the left of it.
     * Place it just behind the element smaller than it.
     * If there is no element smaller than it,
     * then place it at the beginning of the array.
     * (6) Repeat step number 5 until the entire array is sorted.
     * <p>
     * Algorithm:
     * InsertionSort(array A)
     * 1. For i = 1 to length(A) - 1
     * 2.     key = A[i]
     * 3.     j = i - 1
     * 4.     while j >= 0 and A[j] > key
     * 5.         A[j + 1] = A[j]
     * 6.         j = j - 1
     * 7.     A[j + 1] = key
     * <p>
     * Time complexity: O(n^2) in the worst case, where n is the length of the array.
     * Space complexity: O(1), as the algorithm only requires a constant amount of
     * additional memory.
     */
    public static void sort(int[] array) {
        int length = array.length;

        // Iterate over the array
        for (int i = 1; i < length; i++) {
            // Set the current element as the key
            int key = array[i];

            // Shift elements that are greater than key to the right
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            // Elements have been shifted; now Insert the key into the correct position (the place where we have an empty hole).
            array[j + 1] = key;
        }
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
