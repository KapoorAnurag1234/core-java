import java.util.concurrent.Semaphore;
public class SharedResource {
    boolean isAvailble = false;
    Semaphore semaphore = new Semaphore(2);

    public void producer(){
        try {
            semaphore.acquire();
            System.out.println("Producer acquired lock: " + Thread.currentThread().getName());
            isAvailble = true;
            Thread.sleep(4000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Producer releasing lock: " + Thread.currentThread().getName());
            semaphore.release();
        }
    }
}