package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public T remove(int index) {
        if (index < 0 || index > this.values.size()) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        return this.values.remove(index);
    }

    public boolean contains(T element) {
        return this.values.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        validateIndexes(firstIndex, secondIndex);

        T firstElement = this.values.get(firstIndex);
        T secondElement = this.values.get(secondIndex);
        this.values.set(firstIndex, secondElement);
        this.values.set(secondIndex, firstElement);
    }

    private void validateIndexes(int firstIndex, int secondIndex) {
        if (firstIndex > this.values.size() || secondIndex > this.values.size()) {
            throw new IndexOutOfBoundsException("Invalid indexe/s!");
        } else if (firstIndex < 0 || secondIndex < 0) {
            throw new IndexOutOfBoundsException("Negative indexe/s!");
        }
    }

    public int countGreater(T element) {
        int count = (int) this.values.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
        return count;
    }

    public T getMax() {
        if (this.values.isEmpty()) {
            throw new IllegalStateException("Empty list!");
        }
        T max = this.values.get(0);
        for (int i = 0; i < this.values.size(); i++) {
            T currentElement = this.values.get(i);
            if (currentElement.compareTo(max) > 0) {
                max = currentElement;
            }
        }
        return max;
    }

    public T getMin() {
        if (this.values.isEmpty()) {
            throw new IllegalStateException("Empty list!");
        }
        T min = this.values.get(0);
        for (int i = 0; i < this.values.size(); i++) {
            T currentElement = this.values.get(i);
            if (currentElement.compareTo(min) < 0) {
                min = currentElement;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(value);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int size() {
        return this.values.size();
    }

    public T get(int index) {
        return this.values.get(index);
    }
}
