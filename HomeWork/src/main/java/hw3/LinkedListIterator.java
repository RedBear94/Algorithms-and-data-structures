package hw3;

import hw3.iterator.ListIterator;

public class LinkedListIterator<E> extends SimpleLinkedListImpl<E> implements ListIterator<E> {

    private final SimpleLinkedListImpl<E> list;

    private Node<E> current;
    private Node<E> previous;

    public LinkedListIterator(SimpleLinkedListImpl<E> list) {
        this.list = list;
        reset();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        E nextValue = current.item;
        previous = current;
        current = current.next;
        return nextValue;
    }

    @Override
    public void remove() {
        if (previous == null){
            list.firstElement = current.next;
            reset();
        } else {
            previous.next = current.next;
            if ( !hasNext() ) {
                reset();
            } else {
                current = current.next;
            }
        }
    }

    @Override
    public void reset() {
        current = list.firstElement;
        previous = null;
    }

    @Override
    public void insertBefore(E value) {
        Node<E> newItem = new Node<>(value, null);
        if(previous == null) {
            newItem.next = list.firstElement;
            list.firstElement = newItem;
            reset();
        }
        else {
            newItem.next = previous.next;
            previous.next = newItem;
            current = newItem;
        }

    }

    @Override
    public void insertAfter(E value) {
        Node<E> newItem = new Node<>(value, null);
        if (list.isEmpty()){
            list.firstElement = newItem;
            current = newItem;
        } else {
            newItem.next = current.next;
            current.next = newItem;
            next();
        }
    }
}
