package producer_consumer;

public class Producer extends Thread{
    private final Data data;

    public Producer(Data data) {
        this.data = data;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++) {
            try {
                data.produce(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
