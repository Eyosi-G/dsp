import javax.swing.plaf.TableHeaderUI;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CounterThread countInA = new CounterThread("Hello", "a.txt");
        CounterThread countInB = new CounterThread("Hello", "b.txt");
        countInA.start();
        countInB.start();

        countInA.join();
        countInB.join();

    }
}

class ThreadByExtending extends  Thread {
    @Override
    public void run() {
        //logic goes here
    }
}
class Job implements  Runnable {
    @Override
    public void run() {
        System.out.println("inside a thread");
    }
}

class A {
    public void run(){
        System.out.println("doing thing");
    }
}