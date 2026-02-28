import java.util.concurrent.locks.*;
public class SharedResource {
    boolean itemAvailable = false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void producer(){
        try{
            System.out.println("Producer acquiring lock: " + Thread.currentThread().getName());
            lock.lock();
            if(itemAvailable){
                System.out.println("Item is already available, producer waiting: " + Thread.currentThread().getName());
                condition.await();
            }
            itemAvailable = true;
            condition.signalAll();
        }
        catch(Exception e){

        }
        finally{
            lock.unlock();
            System.out.println("Producer releasing lock: " + Thread.currentThread().getName());
        }
    }

    public void consumer(){
        try{
            Thread.sleep(1000);
            lock.lock();
            System.out.println("Consumer acquiring lock: " + Thread.currentThread().getName());
            if(!itemAvailable){
                System.out.println("Item is not available, consumer waiting: " + Thread.currentThread().getName());
                condition.await();
            }
            itemAvailable = false;
            condition.signalAll();
        }
        catch(Exception e){

        }
        finally{
            lock.unlock();
            System.out.println("Consumer releasing lock: " + Thread.currentThread().getName());
        }
    }
   

}