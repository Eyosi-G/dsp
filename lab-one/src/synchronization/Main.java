package synchronization;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountingTask countingTask = new CountingTask();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10 ; i++) {
            Thread thread = new Thread(countingTask);
            threads[i] = thread;
            thread.start();
        }
        for (Thread thread: threads){
            thread.join();
        }
        System.out.println("Total count is " + countingTask.getCount());
    }
}
