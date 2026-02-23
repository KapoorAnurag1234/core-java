public class SharedResourceQueueMain {
    public static void main(String[] args) {
        System.out.println("Main function starts");

        SharedResourceQueue sharedResourceQueue = new SharedResourceQueue(3);

        Thread produceThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedResourceQueue.produce(i);
                }
            } catch (Exception e) {

            }
        });

        Thread consumeThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedResourceQueue.consume();
                }
            } catch (Exception e) {

            }
        });

        produceThread.start();
        consumeThread.start();
        System.out.println("Main function ends");
    }

    
}
