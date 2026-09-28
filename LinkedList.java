import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int size;

    public int size() {
        return size;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Список пуст.");
        }

        head = head.next;
        size--;
    }

    public boolean contains(T value) {
        Node<T> current = head;

        while (current != null) {
            if (value == null && current.value == null) {
                return true;
            }

            if (value != null && value.equals(current.value)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T value = current.value;
                current = current.next;

                return value;
            }
        };
    }
}