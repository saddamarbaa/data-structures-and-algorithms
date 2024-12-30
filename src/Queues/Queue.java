public class Queue {
    private int capacity;
    private   static final int DEFAULT_SIZE = 10;
    private  int first;
    private  int last;
    protected int[]  data;

    public Queue(){
        this.capacity = DEFAULT_SIZE;
       this.data = new int[DEFAULT_SIZE];
       this.first= -1;
       this.last = -1;

    }
    public Queue(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.first= -1;
        this.last = -1;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is Full!! Cannot enqueue " + value);
            resize();  // Resize when the stack is full
            last = last+1;
            data[last] = value;
        } else if (isEmpty()) {
            last = 0;
            first = 0;
            data[last] = value;
        }else {
            last = last+1;
            data[last] = value;
        }

        System.out.println("Enqueue " + value + " to the queue.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty ! Cannot dequeue.");
            return -1;
        } else if (last==first) {
            int dequeueValue = data[last];
            data[last] =0;
            last = -1;
            first = -1;
            return  dequeueValue;
        } else {

            int dequeueValue = data[first];
            for(int i = first; i < last ; i++)
            {
               data[i] = data[i+1];
            }

            last = last -1;
            System.out.println("Dequeued " + dequeueValue + " from the queue.");
            return dequeueValue;
        }
    }

    public void clearQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot clear.");
        } else {
            first = -1;
            last = -1;
            System.out.println("Queue cleared.");
        }
    }

    public int count() {
        if (isEmpty()) {
            return 0;
        }
        return last-first+1 ;
    }

    // Dynamically resize the queue by doubling the capacity
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
            System.out.println("queue is empty!");
        } else {
            System.out.print("queue elements: ");
            for (int i = 0; i <= last; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        return last == capacity - 1;
    }

    public boolean isEmpty() {
        return first == -1 && last == -1;
    }



    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();

        queue.enqueue(60);  // This should resize the queue and add 60

       queue.display();
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.display();

        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Current queue size: " + queue.count());

        queue.clearQueue();
        queue.display();
        queue.enqueue(12);
        queue.display();
        System.out.println("Current queue size is "+ queue.count());
    }
}