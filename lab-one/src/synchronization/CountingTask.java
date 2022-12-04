package synchronization;

public class CountingTask implements Runnable {
    private int count = 0;
    private Object lock = new Object();

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            synchronized (lock) {
                count++;
            }
        }
    }
}
