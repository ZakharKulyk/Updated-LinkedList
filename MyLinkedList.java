package ua.goit.polymorpism.Module9.HomeWork9;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();

        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current.prev == null) {
            this.head = current.next;
        } else {
            current.prev.next = current.next;
        }

        if (current.next == null) {
            this.tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }
        this.size--;
        return current.data;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();

        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Node<T> current = this.head;
        while (current != null) {
            stringBuilder.append(current.data);
            if (current.next != null) {
                stringBuilder.append(',');
            }
            current = current.next;
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

