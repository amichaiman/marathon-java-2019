package ten;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private Queue<Runnable> runnables;
    private boolean threadsActive;

    public ThreadPool(int n) {
        runnables = new LinkedBlockingQueue<>();

        threadsActive = true;
        for(int i=0; i<n; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (threadsActive) {
                        Runnable r = getNextRunnable();
                        try {
                            r.run();
                        } catch (NullPointerException ignored) { }
                    }
                }
            }).start();
        }
    }

    private synchronized Runnable getNextRunnable( ) {
        while (runnables.isEmpty() && threadsActive) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return threadsActive ? runnables.remove() : null;
    }


    public synchronized void execute(Runnable r) {
        runnables.add(r);
        notifyAll();
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(10);
        for (int i=0; i<100; i++) {
            threadPool.execute(new MyRunnable());
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }

    private void shutdown() {
        threadsActive = false;
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
