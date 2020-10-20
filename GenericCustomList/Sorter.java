package CustomList;

public class Sorter<T extends Comparable<T>> {

    public void sort(CustomList customList) {

        for (int i = 0; i < customList.size(); i++) {
             T currentElement = (T) customList.get(i);
            for (int j = i + 1; j < customList.size(); j++) {
                T nextElement = (T) customList.get(j);
                if (currentElement.compareTo(nextElement) > 0) {
                    customList.swap(i, j);
                }
            }
        }
    }
}
