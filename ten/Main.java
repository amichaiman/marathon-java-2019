package ten;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {
    private Queue<Runnable> queue;
    private boolean threadsActive;

    public ThreadPool(int threadCount) {
        queue = new LinkedBlockingQueue<>();
        threadsActive = true;

        for (int i = 0; i<threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (threadsActive) {
                        Runnable r = getNextRunnable();
                        if (!threadsActive) { break; }
                        r.run();
                    }
                }
            }).start();
        }
    }

    private synchronized Runnable getNextRunnable() {
        if (!threadsActive) {
            return null;
        }
        if (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return threadsActive ? queue.remove() : null;
    }
    public synchronized void execute(Runnable r) {
        queue.add(r);
        if (queue.size() == 1) {
            notify();
        }
    }

    public synchronized void shutdown() {
        threadsActive = false;
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(10);
        Thread.sleep(2000);
        threadPool.shutdown();
    }
}
