import java.util.concurrent.locks.ReentrantLock;
public class ReentrantLockMain {
    public static void main(String[] args) {
        System.out.println("Main function starts");
        SharedResorceLock sharedResorceLock1 = new SharedResorceLock();
        ReentrantLock lock = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            sharedResorceLock1.producer(lock);
            System.out.println("Thread 1 completed");
        });
        SharedResorceLock sharedResorceLock2 = new SharedResorceLock();

        Thread thread2 = new Thread(() -> {
            sharedResorceLock2.producer(lock);
            System.out.println("Thread 2 completed");
        });

        thread1.start();
        thread2.start();


    }
}