package leetcode.stack_queue;

public class ArrayQueue<T> {

    private Object[] array;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_SIZE = 10;

    public ArrayQueue() {
        array = new Object[DEFAULT_SIZE];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(T el) {
        if (size == array.length) {
            resize();
        }
        array[rear] = el;
        rear = (rear + 1) % array.length;
        size ++;
    }

    public T dequeue() {
        if(isEmpty()) {
            return null;
        }

        T el = (T) array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size --;

        return el;
    }

    public T peek() {
        if(isEmpty()) {
            return null;
        }

        return (T) array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void resize() {
        int newSize = array.length * 2;
        Object[] newArray = new Object[newSize];

        for(int i = 0; i < array.length; i ++) {
            newArray[i] = array[(front + i) % array.length];
        }

        array = newArray;
        front = 0;
        rear = size;

    }
}
