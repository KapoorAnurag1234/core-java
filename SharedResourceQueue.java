import java.util.LinkedList;
import java.util.Queue;

public class SharedResourceQueue {

    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    SharedResourceQueue(int bufferSize) {
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) {

        // If buffer is full, wait for consume to consume.
        while (sharedBuffer.size() == bufferSize) {
            try {
                System.out.println("Buffer is full, waiting for consumer to consume.");
                wait();
            } catch (Exception e) {

            }

        }

        sharedBuffer.add(item);
        System.out.println("Produced" + item);
        notify();

    }

    public synchronized int consume() {

        while (sharedBuffer.isEmpty()) {
            try {
                System.out.println("Buffer is empty, waiting for producer to add item");
                wait();
            } catch (Exception e) {
            }
        }

        int item = sharedBuffer.poll();
        System.out.println("Consumed:" + item);
        notify();
        return item;

    }

}
