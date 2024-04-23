import java.lang.*;
public class Main {
    public static void main(String[] args) {
        int QUEUE_SIZE = 3;
        SharedQueue sharedQueue = new SharedQueue(QUEUE_SIZE);
        Thread producerThread = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                try {
                    sharedQueue.addElement(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread consumerThread = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                try {
                    sharedQueue.consumeElement();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}