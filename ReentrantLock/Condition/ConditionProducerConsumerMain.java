public class ConditionProducerConsumerMain {
    public static void main(String[] args) {
        System.out.println("Main function starts");
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(() -> {
            for(int i=0;i <2; i++){
                sharedResource.producer();
            }
        });

        Thread consumerThread = new Thread(() -> {
            for(int i=0;i <2; i++){
                sharedResource.consumer();
            }
        });
        producerThread.start();
        consumerThread.start();

        System.out.println("Main function ends");
    }
}