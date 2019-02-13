package six_seven;

public class Main {
    public static void main(String[] args) {
        BlockingArrayStack<Integer> blockingArrayStack = new BlockingArrayStack<>();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(blockingArrayStack.pop());
            }
        });
        t.start();
        try {
            Thread.sleep(5000);
            blockingArrayStack.push(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
