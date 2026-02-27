import java.util.concurrent.locks.ReadWriteLock;
public class SharedResourceReadWriteLock {
    boolean isAvailable = false;

    public void producer(ReadWriteLock lock) {

        try{
            lock.readLock().lock();
            System.out.println("Read Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            System.out.println("Read Lock released by: " + Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }

    public void consumer(ReadWriteLock lock) {

        try{
            lock.writeLock().lock();
            System.out.println("Write Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            System.out.println("Write Lock released by: " + Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }
}