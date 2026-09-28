import java.util.NoSuchElementException;

public class Stack<T> {

    private final LinkedList<T> items = new LinkedList<>();

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T value) {
        items.addFirst(value);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Стек пуст.");
        }

        T value = peek();
        items.removeFirst();

        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Стек пуст.");
        }

        for (T item : items) {
            return item;
        }

        throw new NoSuchElementException("Стек пуст.");
    }
}