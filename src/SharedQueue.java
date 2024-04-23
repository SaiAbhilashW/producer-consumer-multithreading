import java.util.*;
public class SharedQueue {
    Queue<Integer> queue;
    int bufferSize;
    int currentIndex = -1;

    public SharedQueue(int queueSize) {
        this.bufferSize = queueSize;
        queue = new LinkedList<>();
    }

    public synchronized void addElement(int element) throws InterruptedException {
        while(queue.size() == bufferSize) {
            wait();
        }
        System.out.println("Added : " + element);
        queue.add(element);
        notifyAll();
    }

    public synchronized void consumeElement() throws InterruptedException {
        while(queue.isEmpty()) {
            wait();
        }
        int removed = queue.poll();
        System.out.println("Removed : " + removed);
        notifyAll();
    }
}
