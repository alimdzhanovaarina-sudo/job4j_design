package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    @Override
    public void add(E value) {
        SimpleLinkedList.Node<T> newNode = new SimpleLinkedList.Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            SimpleLinkedList.Node<E> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        SimpleLinkedList.Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public T deleteFirst() {

        return null;
    }

    @Override
    public Iterator<T> iterator() {
        /*используйте код из предыдущего задания*/
    }

    private static class Node<T> {
        /*используйте код из предыдущего задания*/
    }
}