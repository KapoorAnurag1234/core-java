import java.util.concurrent.locks.*;
public class ReadWriteLockMain {
    public static void main(String[] args) {

     SharedResourceReadWriteLock sharedResourceReadWriteLock = new SharedResourceReadWriteLock();
      ReadWriteLock lock = new ReentrantReadWriteLock();

      Thread t1 = new Thread(() -> {
        sharedResourceReadWriteLock.producer(lock);
        System.out.println("Thread 1 completed");
      });

      Thread t2 = new Thread(() -> {
        sharedResourceReadWriteLock.producer(lock);
        System.out.println("Thread 2 completed");
      });


      Thread t3 = new Thread(() -> {
        sharedResourceReadWriteLock.consumer(lock);
        System.out.println("Thread 3 completed");
      });

      t1.start();
      t2.start();
      t3.start();



    }
}