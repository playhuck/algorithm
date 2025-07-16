package leetcode.stack_queue.prev;

import java.util.Arrays;

public class ArrayStack<T> {

    private Object[] array;
    private int size;
    private static final int DEFAULT_SIZE = 10;

    public ArrayStack() {
        array = new Object[DEFAULT_SIZE];
        size = 0;
    }

    public void push(T el) {
        capacity();
        array[size++] = el;
    }

    public T pop() {
        if(isEmpty()) return null;

        T el = (T) array[--size];
        array[size] = null;
        return el;
    }

    public T peek() {
        if(isEmpty()) return null;

        return (T) array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void capacity() {
        if(size == array.length){
            int newSize = array.length * 2;
            array = Arrays.copyOf(array, newSize);
        }
    }
}
