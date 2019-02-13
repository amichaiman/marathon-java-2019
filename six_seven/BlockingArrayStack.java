package six_seven;

public class BlockingArrayStack<E> extends ArrayStack<E>{
    public synchronized E peek() {
        if (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return super.peek();
    }

    public synchronized E pop() {
        if (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return super.pop();
    }

    public synchronized void push(E elem) {
        super.push(elem);
        notify();
    }
}
