package producer_consumer;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Integer> data = new ArrayList<>();
    private int size;
    public Data(int size) {
        this.size = size;
    }

    public synchronized  void produce(int value) throws InterruptedException {
        if(data.size() == size){
            this.wait();
        }
        if(data.size() < size){
            data.add(value);
            notifyAll();
            System.out.println("Producer produced " + value);
            Thread.sleep(1000);

        }
    }

    public synchronized void consume() throws InterruptedException {
        if(data.size() == 0){
            this.wait();
        }
        if(data.size() != 0){
            int value = data.remove(0);
            notifyAll();
            System.out.println("Consumer consumed " + value);
            Thread.sleep(1000);

        }
    }
}
