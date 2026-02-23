public class SharedResourceMain {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        System.out.println("In main method");

        Thread producerThread = new Thread(() -> {
            System.out.println("Producer thread" + Thread.currentThread().getName());
            try {
                Thread.sleep(5000l);
            } catch (Exception e) {

            }
            sharedResource.addItem();
        });
        Thread consumerThread = new Thread(() -> {
            System.out.println("Consumer Thread" + Thread.currentThread().getName());
            sharedResource.consumeItem();
        });

        producerThread.start();
        consumerThread.start();

        System.out.println("Main method end");
    }
}
