public class SharedResource {

    boolean itemAvailable = false;

    public synchronized void addItem() {
        itemAvailable = true;
        System.out.println("Item added by" + Thread.currentThread().getName() + "and invoking all threads");
        notifyAll();
    }

    public synchronized void consumeItem() {

        System.out.println("Consume Item method called by" + Thread.currentThread().getName());
        while (!itemAvailable) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now ");
                wait(); // it release all monitor lock;
            } catch (Exception e) {
            }
        }
        System.out.println("Item consumed by: " + Thread.currentThread().getName());
        itemAvailable = false;
    }

}