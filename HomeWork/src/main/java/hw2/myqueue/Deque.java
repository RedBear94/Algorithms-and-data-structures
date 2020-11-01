package hw2.myqueue;

public class Deque<E> extends QueueImpl<E> {
    private int head;
    private int tail;
    private int capacity;

    public Deque(int maxSize) {
        super(maxSize);
        capacity = 0;
        head = 0;
        tail = -1;
        size = maxSize;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public boolean appendRight(E value) {
        if (isFull()) {
            return false;
        }
        if (++tail > size){
            tail = 0;
        }
        data[tail] = value;
        capacity++;
        return true;
    }

    public E popRight() {
        if (tail < 0) tail = size - 1;
        capacity--;
        return data[tail--];
    }

    public boolean appendLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (--head < 0) {
            head = size - 1;
        }
        data[head] = value;
        capacity++;
        return true;
    }

    public E popLeft() {
        if (++head > size)
            head = 1;
        capacity--;
        return data[head - 1];
    }
}
