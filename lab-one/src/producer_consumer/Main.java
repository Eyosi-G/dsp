package producer_consumer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data(5);
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
