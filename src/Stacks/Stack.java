public class Stack {
    private int capacity;
    private   static final int DEFAULT_SIZE = 10;
    private int top;
    protected int[]  data;

    public Stack(){
//        this.capacity = DEFAULT_SIZE;
//        data = new int[DEFAULT_SIZE];
//        top = -1;
        this(DEFAULT_SIZE);
    }
    public Stack(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full! Cannot push " + value);
            resize();  // Resize when the stack is full
        }

        data[++top] = value;
        System.out.println("Pushed " + value + " to the stack.");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1;
        } else {
            int poppedValue = data[top--];
            System.out.println("Popped " + poppedValue + " from the stack.");
            return poppedValue;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot peek.");
            return -1;
        } else {
            return data[top];
        }
    }

    public int count() {
        return top + 1;
    }

    // Dynamically resize the stack by doubling the capacity
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;  // Doubling the capacity
        int[] newArr = new int[newCapacity];

        // Copy existing elements to the new array
        for (int i = 0; i < capacity; i++) {
            newArr[i] = data[i];
        }

        // Update the reference to the new array and capacity
        data= newArr;
        capacity = newCapacity;

        System.out.println("Stack capacity increased to " + capacity);
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void change(int index, int newValue) {
        if (index >= 0 && index <= top) {
            data[index] = newValue;
            System.out.println("Changed value at index " + index + " to " + newValue);
        } else {
            System.out.println("Invalid index! Cannot change value.");
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.display();

        stack.push(60);  // This should print that the stack is full.

        System.out.println("Peek top: " + stack.peek());

        stack.pop();
        stack.pop();

        stack.display();

        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Current stack size: " + stack.count());

        // Change value at index 1
        stack.change(1, 100);

        stack.display();
    }
}