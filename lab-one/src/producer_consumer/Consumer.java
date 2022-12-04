package producer_consumer;

public class Consumer extends Thread{
    private final Data data;

    public Consumer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            try {
                data.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
