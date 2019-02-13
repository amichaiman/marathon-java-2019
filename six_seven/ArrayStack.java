package six_seven;

import java.util.ArrayList;

public class ArrayStack<E> {
    private ArrayList<E> arrayList;

    public ArrayStack() {
        arrayList = new ArrayList<>();
    }

    public int size() {
        return arrayList.size();
    }
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }
    public void clear() {
        arrayList.clear();
    }
    public void push(E elem) {
        arrayList.add(elem);
    }
    public E peek() {
        return arrayList.get(arrayList.size()-1);
    }
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E elem = arrayList.get(arrayList.size()-1);
        arrayList.remove(arrayList.size()-1);
        return elem;
    }
}
