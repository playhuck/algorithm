package leetcode.stack_queue.prev;

public class CircularQueue<T> {
    private Object[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.array = new Object[this.capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(T el) {
        if(isFull()) {
            throw new RuntimeException("Queue is full");
        }

        rear = (rear + 1) % capacity;
        array[rear] = el;
        size ++;
    }

    public T dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        T el = (T) array[front];
        array[front] = null;
        front = (front + 1) % capacity;
        size --;

        return el;

    }

    public T peek() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return (T) array[front];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
